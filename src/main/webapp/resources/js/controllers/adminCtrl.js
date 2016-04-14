'use strict';
app.controller('adminCtrl', ['$scope','adminService','loginService', function ($scope,adminService,loginService) {
    $scope.tabs = [{
            title: 'Product Category',
            url: 'resources/partials/tpl/productCategory.tpl.html',
            id:'1'
        }, {
            title: 'Products',
            url: 'resources/partials/tpl/product.tpl.html',
            id:'2'
        }, {
            title: 'Orders',
            url: 'resources/partials/tpl/order.tpl.html',
            id:'3'
        }];

    $scope.currentTab = 'resources/partials/tpl/productCategory.tpl.html';
    $scope.saveStatus="";
   
    
    $scope.onClickTab = function (tab) {
    	if(tab.id == '1'){
    		$scope.getProductCategories();
    	}else if(tab.id == '2'){
    		$scope.getAllProducts();
    		getProductByCat();
    	}else if(tab.id == '3'){
    		$scope.getAllOrders();
    	}
    	 
        $scope.currentTab = tab.url;
    };
    
    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    };
    
    $scope.getProductCategories = function(){
    	adminService.getProductCategories().then(function(pCats) {
    		$scope.productCategories = pCats;
    	});
	};
	
	 function  getAllProducts(){
		adminService.getAllProducts().then(function(products){
			$scope.products = products;
		});
	};
	
	 $scope.getAllOrders = function(){
	    	adminService.getAllOrders().then(function(orders) {
	    		$scope.orders = orders;
	    	});
		};
	$scope.editOrder = function(order){
			$scope.order = order;
	};
	$scope.editProduct = function(product){
		$scope.product = product;
};
	$scope.updateOrder=function(order){
	    	adminService.updateOrder(order,$scope);
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








