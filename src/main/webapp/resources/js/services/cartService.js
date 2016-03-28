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
    	var orderDetails = new Array();
    	var totalAmount = 0.0;
    	angular.forEach(cart.cartDetails, function(cartDetail){
    		var orderDetail = new Object();
    		orderDetail.productId = cartDetail.productId;
    		orderDetail.quantity = cartDetail.quantity;
    		totalAmount = totalAmount + cartDetail.productPrice;
    		orderDetails.push(orderDetail);
    	});
    	var order = new Object();
    	order.loginId= cart.loginId;
    	order.totalAmount= totalAmount;
    	order.orderDetails = orderDetails;
    	order.status = "InProgress";
    	
    			var res = $http.post('http://localhost:8080/upm/createorder', order);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    			});	
    			
    		},
   
    };
 
}]);







