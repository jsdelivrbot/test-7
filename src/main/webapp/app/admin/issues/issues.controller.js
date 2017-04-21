(function() {
    'use strict';

    angular
        .module('gwApp')
        .controller('IssuesController', IssuesController);

    IssuesController.$inject = ['$rootScope','$scope','$state','StorageDataService', 'issues_data','IssuesService','GitlabErrorService','inputLocker'];

    function IssuesController ($rootScope, $scope, $state, StorageDataService, issues_data, IssuesService, GitlabErrorService,inputLocker) {
        var vm = this;
        vm.issues =  issues_data;
        vm.exportData = exportData;
        vm.getPages = getPages;
        vm.onClickPage = onClickPage;
        //vm.proyect = StorageDataService.getProject();
        //console.log("name:: "+vm.proyect.name_with_namespace);
        var request = [];
        

        function exportData () {
            var pagination = StorageDataService.getPaginationIssues();
            console.log("total pages "+pagination.totalpages);
            console.log("total "+pagination.total);
            StorageDataService.setExportData(null);
                
            for (var i = 1; i <= pagination.totalpages; i++) {
                console.log("req "+i);
                inputLocker.lock();
                IssuesService.get({"projectId":StorageDataService.getProject().id,"token":StorageDataService.getGitlabToken(),"page":i},onSuccessExport, onErrorExport);              
                inputLocker.unlock();
            }
              

        }
         function onSuccessExport(response){
            var pagination = StorageDataService.getPaginationIssues();
            request.push(response.length);
            var exportData = StorageDataService.getExportData();
            var array_result;
            if(exportData!=null && exportData!=undefined ){
                array_result = exportData.concat(response);
                
            }else{
                array_result = response;
            }
            

            StorageDataService.setExportData(array_result);
            console.log("last "+request.length);
            //{headers:false,separator:",",utf8Bom: true}
            if(request.length==pagination.totalpages){
                request = [];
                var opts = {
                    headers: true,
                    utf8Bom: true
                    
                    /*caption: {
                      title:'Projecto: '+StorageDataService.getProject().name,
                     
                    },*/
                };
                alasql('SEARCH / AS @a \ UNION ALL( \
                          @a->milestone AS @b \
                          @a->assignee  AS @c \
                          @a->author  AS @d \
                 RETURN(@a->id AS id, @a->iid AS iid, @a->project_id AS "id Proyecto", @a->title AS "Título", @a->description AS "Descripción", \
                            @a->state AS "Estado", @a->created_at AS "Fecha de creación ", @a->updated_at AS "Fecha de actualización", @a->labels AS "Etiquetas", \
                            @a->user_notes_count AS "Número de notas del usuario", @a->upvotes AS "Votos a favor", @a->downvotes AS "Votos en contra", @a->due_date AS "Fecha de vencimiento", \
                            @a->confidential AS "Confidencial", @a->web_url AS "web URL", \
                            @b->id AS "Milestone id", @b->iid as "Milestone iid", @b->project_id AS "Milestone id projecto", @b->title AS "Milestone título", \
                            @b->description AS "Milestone descripción",@b->state AS "Milestone estado", @b->created_at AS "Milestone fecha de creación", \
                            @b->updated_at AS "Milestone fecha de actualización",@b->due_date AS "Milestone fecha de vencimiento", @b->start_date AS "Milestone fecha de inicio", \
                            @c->name AS "Asignado nombre", @c->username AS "Asignado nombre de usuario", @c->id AS "Asignado id", @c->state AS "Asignado estado", \
                            @c->avatar_url AS "Asignado URL avatar ", @c->web_url AS "Asignado web URL", @d->name AS "Autor nombre", @d->username AS "Autor nombre de usuario", \
                            @d->id AS "Autor id", @d->state AS "Autor estado", @d->avatar_url AS "Autor URL avatar", @d->web_url AS "Autor web URL  " \
                )) \ INTO XLSX("project.xlsx",?)   FROM ? ',[opts, StorageDataService.getExportData()]);
            
            }
            
        }
        function onErrorExport(){
            
        }
        function onClickPage(numberPage){
            IssuesService.get({"projectId":StorageDataService.getProject().id,"token":StorageDataService.getGitlabToken(),"scope":"all","state":"all","page": numberPage},onSuccessIssues, onErrorIssues);
        };

        function onSuccessIssues(response){
            
            var data = angular.fromJson(response);
            
            StorageDataService.setIssuesByProject(data);

            vm.issues =  data;
        }
        function onErrorIssues(error){
            console.log("onerror");
            GitlabErrorService.open();
            StorageDataService.clearSession();
            $state.go('/');
        }

        function getPages(){
            var array = [];
            
            var pagination = StorageDataService.getPaginationIssues();
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

        };
        
    }
})();