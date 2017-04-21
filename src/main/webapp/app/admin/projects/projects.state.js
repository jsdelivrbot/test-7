(function() {
    'use strict';

    angular
        .module('gwApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('projects', {
            parent: 'admin',
            url: '/projects',
            data: {
                authorities: [],
                pageTitle: 'projects.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/projects/projects.html',
                    controller: 'ProjectsController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                
                data_projects : function ( StorageDataService, ProjectsService) {
                    //return StorageDataService.getProjects();

                    if(StorageDataService.getGitlabToken()!=null && StorageDataService.getGitlabToken()!=undefined ){
                    /*
                        return  ProjectsService.get({"token":StorageDataService.getGitlabToken()},function(response){
                            console.log("service projects state")
                            StorageDataService.setProjects(response);
                            return response;
                        });  */
                       return StorageDataService.getProjects();
                    }

                },
                
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('logs');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
