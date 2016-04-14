'use strict';
app.controller('cartCtrl', function($scope,loginService,cartService,sessionService,userService){
	
	$scope.lId = sessionService.get('emailId');
	$scope.noItemInCart = false;
	
	if(null!=$scope.lId && $scope.lId!=''){
		cartService.getCart($scope.lId).then(function(cart) {
			if(cart.cartDetails.length<1){
				$scope.noItemInCart = true;
			}else{
				$scope.cart= cart;
				userService.getUser($scope.lId).then(function(user) {
					$scope.user= user;
			    });
			}
	    });
		
	}

	$scope.remove=function($scope, cartDetail){
		 cartService.remove(cartDetail);
	};
	
	$scope.createOrder=function(cart){
		 cartService.createOrder(cart);
	};
	
	$scope.logout=function(){
		loginService.logout();
	};
	
	
	$scope.isLogged = function(){
		return loginService.isLogged();
	};
	
	 $scope.getStates=function(){
		   userService.getStates($scope);
	};
	
	$scope.getStates();
	
});
