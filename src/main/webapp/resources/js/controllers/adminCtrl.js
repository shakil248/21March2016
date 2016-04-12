'use strict';
app.controller('adminCtrl', ['$scope','adminService','loginService', function ($scope,adminService,loginService) {
    $scope.tabs = [{
            title: 'Product Category',
            url: 'resources/partials/tpl/productCategory.tpl.html'
        }, {
            title: 'Product',
            url: 'resources/partials/tpl/product.tpl.html'
        }];

    $scope.currentTab = 'resources/partials/tpl/productCategory.tpl.html';
    $scope.saveStatus="";

    $scope.onClickTab = function (tab) {
    	 $scope.getProductCategories();
        $scope.currentTab = tab.url;
    };
    
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    };
    
    $scope.getProductCategories = function(){
    	adminService.getProductCategories($scope).then(function(pCats) {
    		$scope.productCategories = pCats;
    	});
	};
    
    $scope.createProductCat=function(productCat){
		adminService.createProductCat(productCat,$scope);
    };
    $scope.clearProductCat = function(productCat){
		$scope.productCat=null;
		 $scope.errorMessage="";
	};
	$scope.editProductCat = function(productCat){
		$scope.productCat = productCat;
	};
    $scope.createProduct=function(product){
    		adminService.createProduct(product,$scope);
	};
	
	$scope.clearProduct = function(product){
		$scope.product=null;
		 $scope.errorMessage="";
	};
	
	$scope.isLogged = function(){
		return loginService.isLogged();
	};
}]);








