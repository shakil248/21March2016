'use strict';
app.factory('adminService',['$http', function($http) {
	
	
    return {
    	createProductCat: function(productCat,scope) { 
			var res = $http.post('http://localhost:8080/upm/createproductcat', productCat);
			res.success(function(data, status, headers, config) {
				  console.log("Success", data);
				  scope.saveStatus = "Saved Successfuly";
					
			});
			res.error(function(data, status, headers, config) {
				 console.log(data);
				 scope.saveStatus = "!Oops saving failed";
			});	
			
			},
    	createProduct: function(product,scope) { 
    			product.data = getBase64Image();
    			var res = $http.post('http://localhost:8080/upm/createproduct', product);
    			res.success(function(data, status, headers, config) {
    				  console.log("Success", data);
    				  scope.saveStatus = "Saved Successfuly";
  					
    			});
    			res.error(function(data, status, headers, config) {
    				 console.log(data);
    				 scope.saveStatus = "!Oops saving failed";
    			});	
    			
    			},
    	 getUser: function(lId){
				var promise  = $http.get('http://localhost:8080/upm/getuser',{params: {loginId: lId}}).
                then(function  (response) {
                	setImage(response.data.data);
                    return response.data;
                });
				return promise ;
    		 
    	 },		
    	 getProductCategories: function(scope) {
    		 var res = $http.get('http://localhost:8080/upm/getallproductcat');
    		 res.success(function(data, status, headers, config) {
				  console.log("Success get States", data);
				  scope.productCategories = data;
			});
			res.error(function(data, status, headers, config) {
				 console.log("Failure get States");
			});	

    	 },
    	 
    	 uploadImage:function(files){
    		 var productImg = document.getElementById('productImg');
    		 productImg.src = URL.createObjectURL(files[0]);
    	 },
    	 clearImage:function(){
    		 document.getElementById("productImg").src = "";
    	 }
    };
    
    function setImage(data){
    	document.getElementById("productImg").src = data;
    }
	function getBase64Image(){     
		var p;var canvas = document.createElement("canvas");
		var img1=document.createElement("img"); 	
	
	    p=document.getElementById("productImg");
	    img1.setAttribute('src', p.src); 
	    canvas.width = img1.width; 
	    canvas.height = img1.height; 
	    var ctx = canvas.getContext("2d"); 
	    ctx.drawImage(img1, 0, 0); 
	    var dataURL = canvas.toDataURL("image/png");
	    return dataURL;
} 
}]);







