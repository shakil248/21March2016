'use strict';
app.controller('adminCtrl', ['$scope','adminService', function ($scope,adminService) {
    $scope.tabs = [{
            title: 'Product Category',
            url: 'resources/partials/tpl/productCategory.tpl.html'
        }, {
            title: 'Product',
            url: 'resources/partials/tpl/product.tpl.html'
        }, {
            title: 'Three',
            url: 'resources/partials/tpl/three.tpl.html'
    }];

    $scope.currentTab = 'one.tpl.html';

    $scope.onClickTab = function (tab) {
    	 $scope.getProductCategories();
        $scope.currentTab = tab.url;
    };
    
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    };
    
    $scope.getProductCategories=function(){
    	adminService.getProductCategories($scope);
	};
    
    $scope.createProductCat=function(productCat){
		adminService.createProductCat(productCat,$scope);
    };
    $scope.clearProductCat = function(productCat){
		$scope.productCat=null;
		 $scope.errorMessage="";
	};
    $scope.createProduct=function(product){
    		adminService.createProduct(product,$scope);
	};
	
	$scope.uploadImage = function(files) {
		 $scope.imageLoaded=true;
		 adminService.uploadImage(files);
	};
	
	$scope.clearProduct = function(product){
		$scope.product=null;
		adminService.clearImage();
		 $scope.imageLoaded=false;
		 $scope.errorMessage="";
	};
}]);








