(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('GLUserService', GLUserService);

    GLUserService.$inject = ['$resource','StorageDataService'];

    function GLUserService ($resource, StorageDataService) {
        
        var service = $resource('/gitlab/api/user/', {}, {
            
            'get': {
                method: 'GET',
                transformResponse: function (data, headers) {
                    
                    
                    
                    
                    if(data){
                        data = angular.fromJson(data);
                       
                    }
                    return data;
                    
                    
                }
            }
            
        });

        return service;
    }
})();