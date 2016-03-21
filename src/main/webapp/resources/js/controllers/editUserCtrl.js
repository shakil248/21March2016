'use strict';
app.controller('userCtrl', function($scope,userService,sessionService){
	
	$scope.lId = sessionService.get('loginId');
	$scope.user = userService.getUser(lId);
	
    $scope.updateUser=function(user, files){
	   userService.createUser(user,$scope,  files);
	};
	
	 $scope.upload=function(files){
		   userService.upload(files);
	};

});
