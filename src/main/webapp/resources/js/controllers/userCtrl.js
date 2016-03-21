'use strict';
app.controller('userCtrl', function($scope,userService,sessionService, loginService){
	
	$scope.lId = sessionService.get('loginId');
	$scope.errorMessage="";
	$scope.imageLoaded=false;
	
	if(null!=$scope.lId && $scope.lId!=''){
		userService.getUser($scope.lId).then(function(user) {
			$scope.user= user;
			$scope.imageLoaded=true;
	    });
	}
	
	
    $scope.createUser=function(user){
    	if(user.password.length>5 && user.password.length<11){
    		userService.createUser(user,$scope);
    		$scope.errorMessage="";
    	}else{
    		$scope.errorMessage = 'Password length should be between 6 to 10';
    	}
          
	};
	

	
	 $scope.getStates=function(){
		   userService.getStates($scope);
	};
	
	$scope.logout=function(){
		loginService.logout();
	};
	
	$scope.getStates();
	
	$scope.uploadImage = function(files) {
		 $scope.imageLoaded=true;
	   userService.uploadImage(files);
	};
	
	$scope.clearUser = function(user){
		$scope.user=null;
		 userService.clearImage();
		 $scope.imageLoaded=false;
		 $scope.errorMessage="";
	};
	
	$scope.isLogged = function(){
		return loginService.isLogged();
	};
	  
	
});
