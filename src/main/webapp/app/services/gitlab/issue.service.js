(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('IssuesService', IssuesService);

    IssuesService.$inject = ['$resource', 'StorageDataService'];

    function IssuesService ($resource, StorageDataService) {


        var service = $resource('/gitlab/api/user/projects/:projectId/issues', {projectId:'@id'},{
            
            'get': {
                method: 'GET', isArray: true,
                
                transformResponse: function (data,headers) {
                    var pagination = {};
                    pagination.next = headers("x-next-page");
                    pagination.prev = headers("x-prev-page");
                    pagination.actual = headers("x-page");
                    pagination.total = headers("x-total");
                    pagination.totalpages = headers("x-total-pages");
                    console.log("total pages"+headers("x-total-pages"));
                    StorageDataService.setPaginationIssues(pagination);

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
