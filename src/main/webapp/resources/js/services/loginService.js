'use strict';
app.factory('loginService', function($location,$http,sessionService) {
	
    return {
        login: function(scope) { 
		
		var res = $http.get('http://localhost:8080/upm/dologin', {params : {'loginId':scope.loginId, 'password':scope.password, 'otp':scope.generatedOTP}});
		res.success(function(data, status, headers, config) {
			  console.log("Success", data);
			  if(data==true){
				  $location.path('/user');  
			  }else{
				  	scope.loginStats="Login failed";
			  }
		});
		res.error(function(data, status, headers, config) {
			 console.log("Failure");
		});	
		},
		
		generateotp: function(lId){
				var promise  = $http.get('http://localhost:8080/upm/generateotp',{params: {loginId: lId}}).
                then(function  (response) {
                    return response.data.otp;
                });
				return promise ;
				
		},
	
		logout: function(){
				if(sessionService.get('loginId')){
					sessionService.destroy('loginId');
					$location.path('/login');
				}
		},
		isLogged: function() {
			if(sessionService.get('loginId')) {return true;} else {return false;}
		}
		
    };
});