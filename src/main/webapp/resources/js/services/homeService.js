'use strict';
app.factory('homeService',['$http','sessionService','config', function($http,sessionService,config) {
    return {
    	getProductByCat: function(pcId,scope) { 
    		
    		var promise  = $http.get(config.apiUrl+'getproductbycat',{params: {productCatId: pcId}}).
            then(function  (response) {
                return response.data;
            });
			return promise ;
			},

		addToCart: function(product){
			
			var cartDetails = new Array();
			var cartDetail = new Object();
			cartDetail.productId = product.productId;
			cartDetail.productName = product.productName;
			cartDetail.productPrice = product.productPrice;
			cartDetail.quantity = product.quantity;
			cartDetails.push(cartDetail);
			
			
			var cart = new Object();
			cart.cartDetails = cartDetails;
			cart.loginId = sessionService.get('loginId');
			
			
			var res = $http.post(config.apiUrl+'addtocart', cart);
			res.success(function(data, status, headers, config) {
				  console.log("Success", data);
					
			});
			res.error(function(data, status, headers, config) {
				 console.log(data);
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







