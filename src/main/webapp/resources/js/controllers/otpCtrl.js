'use strict';
app.controller('otpCtrl', function($scope,$location, loginService,sessionService){
	
	if("null"!=sessionService.get('loginId')){
		$scope.lId = sessionService.get('loginId');
		loginService.generateotp($scope.lId).then(function(obj) {
	        if(undefined ==obj){
	        	$scope.message="Login Id does not exist";
	        }
			$scope.otp=obj;
	        
	    });
	}
});








