'use strict';
app.factory('cartService',['$http', function($http) {
	
	  return {
    	remove: function(cartDetail) { 
    			var res = $http.post('http://localhost:8080/upm/removecartitem', cartDetail);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
    				  scope.saveStatus = "Removed Successfuly";
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    				 scope.saveStatus = "!Oops  failed";
    			});	
    			
    			},
    	 getCart: function(lId){
				var promise  = $http.get('http://localhost:8080/upm/getcart',{params: {loginId: lId}}).
                then(function  (response) {
                    return response.data;
                });
				return promise ;
    		 
    	 	},
    createOrder: function(cart) { 
    			var res = $http.post('http://localhost:8080/upm/createorder', cart);
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







