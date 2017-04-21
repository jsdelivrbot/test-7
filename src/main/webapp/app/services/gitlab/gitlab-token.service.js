


(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('GitlabToken', GitlabToken);

    GitlabToken.$inject = ['$resource', 'StorageDataService','$http','$q'];

    function GitlabToken ($resource, StorageDataService, $http, $q) {
        
        

        var service = $resource('/gitlab/api/connection/token', {}, {
            
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                       // data = JSON.stringify(data);
                    }
                     
                    return data;
                }
            }
            
        });
        return service;
        
    }
})();
