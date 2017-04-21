(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('GitlabInfo', GitlabInfo);

    GitlabInfo.$inject = ['$resource', 'StorageDataService','$http','$q'];

    function GitlabInfo ($resource, StorageDataService, $http, $q) {
        
        

        var service = $resource('/gitlab/api/connection', {}, {
            
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    
                    return data;
                }
            }
            
        });
        return service;
        
    }
})();
