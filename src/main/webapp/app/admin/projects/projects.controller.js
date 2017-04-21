(function() {
    'use strict';

    angular
        .module('gwApp')
        .controller('ProjectsController', ProjectsController);

    ProjectsController.$inject = ['$scope','StorageDataService', 'data_projects','IssuesService','ProjectsService','GitlabErrorService','$state'];

    function ProjectsController ( $scope, StorageDataService, data_projects, IssuesService, ProjectsService,GitlabErrorService ,$state) {
        var vm = this;

        vm.metrics = {};

        
        vm.projects = data_projects;
        
        vm.onClickProject = onClickProject;
        
        vm.getPages = getPages;

        vm.onClickPage = onClickPage;

        

        function onClickProject(project){
            
            StorageDataService.setProject(project);
            
            if(StorageDataService.getGitlabToken()!=null && StorageDataService.getGitlabToken()!=undefined){
                
                $state.go('issues',{projectId:StorageDataService.getProject().id});
                //IssuesService.get({"projectId":StorageDataService.getProject().id,"token":StorageDataService.getGitlabToken(),"scope":"all","state":"all"},onSuccessIssues, onErrorIssues);
            }
           

        }

        function onSuccessIssues(response){
            
            var data = angular.fromJson(response);
            
            StorageDataService.setIssuesByProject(data);
            if(data!=null && data.length>0){
                $state.go('issues',{projectId:StorageDataService.getProject().id});
            }else{

            }
        }
        function onErrorIssues(error){
            console.log("onerror");
            GitlabErrorService.open();
            StorageDataService.clearSession();
            $state.go('/');
        }


        function onClickPage(numberPage){
            ProjectsService.get({"token":StorageDataService.getGitlabToken(),"page": numberPage},onSuccessProjects, onErrorProjects);      
        };

        function onSuccessProjects(response){
            StorageDataService.setProjects(response);
            vm.projects = response;
            var pagination = StorageDataService.getPaginationProjects();
            vm.totalpages = pagination.totalpages;
            vm.actual = pagination.actual;
            
        }
        function onErrorProjects(error){
             console.log("onerror projects info");
            GitlabErrorService.open();
            StorageDataService.clearSession();
              $state.go('/');
        }


        function getPages(){
            var array = [];
            var pagination = StorageDataService.getPaginationProjects();
            vm.totalpages = pagination.totalpages;
            vm.actual = pagination.actual;
            
            var param_range = 5;
            var min_ = (vm.actual - param_range) > 0 ? (vm.actual - param_range) : 0;
            var max_ = (min_ + param_range * 2) > vm.totalpages ? vm.totalpages : (min_  + param_range * 2);

            

            if(vm.totalpages!=undefined && vm.totalpages!=null){
                for (var i = min_; i < max_; i++) {
                    array.push(min_);
                    min_ = min_ + 1;
                }
            }
            
            return array;

        }



    }
})();
