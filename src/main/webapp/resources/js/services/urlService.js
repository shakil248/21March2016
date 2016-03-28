'use strict';
app.factory('urlService',['$http', function($http) {
    return {
    	getURL: function() { 
    		 $http.get('connection.properties').then(function (response) {
    			 console.log('b is ', response.data.b);
    			 console.log('b is ', response.data.url);
    		       return response.data.url;
    		      });	
    			}
    };
}]);







