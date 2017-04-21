(function() {
    'use strict';

    angular
        .module('gwApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('issues', {
            parent: 'admin',
            reload: true, notify: false, 
            url: '/projects/:projectId/issues',
            data: {
                authorities: [],
                pageTitle: 'projects.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/issues/issues.html',
                    controller: 'IssuesController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                
                issues_data: function(StorageDataService, IssuesService, $stateParams, $q){
                     
                    var project_id = $stateParams.projectId;
                    var project = {};

                    if( project_id != StorageDataService.getProject().id){
                        project.id = project_id;
                    }else{
                        project = StorageDataService.getProject();
                    }

                    StorageDataService.setProject(project);

                    if(StorageDataService.getGitlabToken()!=null && StorageDataService.getGitlabToken()!=undefined ){
                        return IssuesService.get({"projectId":project_id,"token":StorageDataService.getGitlabToken(),"scope":"all","state":"all"},
                            function(response){

                                var data = angular.fromJson(response);
                                StorageDataService.setIssuesByProject(data);
                                return data;
                                
                            });
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
