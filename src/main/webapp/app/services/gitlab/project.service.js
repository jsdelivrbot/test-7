(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('ProjectsService', ProjectsService);

    ProjectsService.$inject = ['$resource','StorageDataService'];

    function ProjectsService ($resource, StorageDataService) {
        
        var service = $resource('/gitlab/api/user/projects', {}, {
            
            'get': {
                method: 'GET', isArray: true,
                transformResponse: function (data, headers) {
                    
                    var pagination = {};
                    pagination.next = headers("x-next-page");
                    pagination.prev = headers("x-prev-page");
                    pagination.actual = headers("x-page");
                    pagination.total = headers("x-total");
                    pagination.totalpages = headers("x-total-pages");
                    console.log("total pages"+pagination.totalpages);
                    
                    
                    if(data){
                        data = angular.fromJson(data);
                        StorageDataService.setPaginationProjects(pagination);
                    }
                    return data;
                    
                    
                }
            }
            
        });

        return service;
    }
})();
            /*

X-Next-Page:
X-Page:
X-Prev-Page:
X-Total
X-Total-Pages:
             * */