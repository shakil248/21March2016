'use strict';
app.controller('homeCtrl', ['$scope','homeService','adminService','loginService', function ($scope,homeService,adminService,loginService) {
	$scope.tabs = new Array();
	
    $scope.getProductCategories = function (){
    	adminService.getProductCategories($scope).then(function(pCats) {
    		
    		angular.forEach(pCats, function(productCat, index) {
        		if(index==0){
        			$scope.currentTab = 'resources/partials/tpl/home/'+productCat.productCatName+'.tpl.html';
        		}
        		  $scope.tabs.push({title:productCat.productCatName,catId:productCat.productCatId, url:$scope.currentTab});
        	});
    		
    	});
    	
    };
    
    $scope.getProductCategories();

    $scope.onClickTab = function (tab) {
    	 $scope.getProductByCat(tab.catId);
    };
    
    $scope.getProductByCat = function(title) {
    	homeService.getProductByCat(title).then(function(products) {
    		$scope.products = products;	
    	});
    };
    
    $scope.addToCart = function(product) {
    	homeService.addToCart(product);
    };
    
    $scope.isLogged = function(){
		return loginService.isLogged();
	};
	
	
}]);