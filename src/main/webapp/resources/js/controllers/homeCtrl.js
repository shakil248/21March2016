'use strict';
app.controller('homeCtrl', ['$scope','homeService','adminService','loginService', function ($scope,homeService,adminService,loginService) {
	$scope.tabs = new Array();
	$scope.productCats;
	
    $scope.getProductCategories = function (){
    	adminService.getProductCategories($scope).then(function(pCats) {
    		$scope.productCats = pCats;
    	});
    };
    
    $scope.getProductCategories();

    $scope.onClickTab = function (pcId) {
    	 $scope.getProductByCat(pcId);
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
	$scope.logout=function(){
		loginService.logout();
	};
	
}]);