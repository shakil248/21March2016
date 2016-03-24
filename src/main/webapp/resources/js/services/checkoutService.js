'use strict';
app.factory('checkoutService',['$http', function($http) {
	
    return {
    	createOrder: function(order) { 
    			var res = $http.post('http://localhost:8080/upm/createorder', order);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
    				  scope.saveStatus = "Order created Successfuly";
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    				 scope.saveStatus = "!Oops creation failed";
    			});	
    			
    			},
    	
    	
    };
    
}]);







