'use strict';
app.controller('checkoutCtrl', function($scope,checkoutService,sessionService, loginService){
	
	
	$scope.lId = sessionService.get('loginId');
	$scope.isCartEmpty=true;
	
	if(null!=$scope.lId && $scope.lId!=''){
		cartService.getCart($scope.lId).then(function(cart) {
			$scope.cart= cart;
			$scope.isCartEmpty=false;
	    });
		userService.getUser($scope.lId).then(function(user) {
			$scope.user= user;
	    });
	}
	
	$scope.logout=function(){
		loginService.logout();
	};
	
	$scope.createOrder=function(){
		checkoutService.createOrder($scope.lId);
	};
	
	
	
	
	
});
