(function() {
    'use strict';

    angular
        .module('gwApp')
        .factory('StorageDataService', StorageDataService);

    StorageDataService.$inject = ['$localStorage'];

    function StorageDataService ($localStorage) {
        var service = {
            setCode:setCode,
            getCode:getCode,
            getToken: getToken,

            setGLUser:setGLUser,
            getGLUser:getGLUser,
            setGitlabCode:setGitlabCode,
            getGitlabCode:getGitlabCode,
            setGitlabToken: setGitlabToken,
            getGitlabToken: getGitlabToken,
            setRequestInfo:setRequestInfo,
            getRequestInfo:getRequestInfo,
           	
            setProject:setProject,
            getProject:getProject,

            setProjects:setProjects,
            getProjects:getProjects,
            
            setIssuesByProject:setIssuesByProject,
            getIssuesByProject:getIssuesByProject,
            setExportData:setExportData,
            getExportData:getExportData,
            
            setPaginationIssues:setPaginationIssues,
            getPaginationIssues:getPaginationIssues,
            setPaginationProjects:setPaginationProjects,
            getPaginationProjects:getPaginationProjects,

            setGitlabAuth:setGitlabAuth,
            getGitlabAuth:getGitlabAuth,
            clearSession:clearSession
        };

        return service;
        function setGitlabCode(code){
            $localStorage.gitlabCode = code;
        }
        function getGitlabCode(){
            return $localStorage.gitlabCode;
        }

        function setGitlabToken(token){
            
            $localStorage.gitlabToken = token;
            
        }
        function getGitlabToken(){
            
            return $localStorage.gitlabToken;
            //$localStorage.gitlabToken;;//"5ab09d08cbba7445fbf849d99e8c02177144f6387a671c47817f887c554c29c";
            //$localStorage.gitlabToken;
        }
        function setCode(code){

            $localStorage.code = code;
        }
        function getCode(){
            return $localStorage.code
        }
        function setRequestInfo(info){
            
            $localStorage.infoRequest =  info;
        }
        function getRequestInfo(){
            return $localStorage.infoRequest;
        }

        function getToken () {
            return $localStorage.authenticationToken || $localStorage.authenticationToken;
        }
        function setGLUser(user_data){
            $localStorage.glUser =  user_data;
        }
        function getGLUser(){
            return $localStorage.glUser;
        }
        function setProject(project){
            $localStorage.project = project;
             
        }
        function getProject(){
            
            return $localStorage.project;
        }
        function setIssuesByProject(issues_data){
            $localStorage.issues = issues_data;
        }

        function getIssuesByProject(){
            return $localStorage.issues;
            
        }

        function setProjects(data_projects){
            $localStorage.projects = data_projects;
        }
        function getProjects(){
            return $localStorage.projects;
        }

        function setExportData(export_data){
            $localStorage.exportData = export_data;
        }
        function getExportData(){
            return $localStorage.exportData;
        }
        function setPaginationIssues(pagination_data){
            $localStorage.paginationIssues = pagination_data;
        }
        function getPaginationIssues(){
            return  $localStorage.paginationIssues;
        }
        function setPaginationProjects(pagination_data){
            $localStorage.paginationProjects = pagination_data;
        }
        function getPaginationProjects(){
            return  $localStorage.paginationProjects;
        }
        function clearSession(){
            $localStorage.gitlabToken = null;
            $localStorage.gitlabCode = null;
            $localStorage.gitlabAuth = false;
            $localStorage.infoRequest =  null;
        }
        function setGitlabAuth(flag){
            $localStorage.gitlabAuth = flag;
        }
        function getGitlabAuth(){
            return $localStorage.gitlabAuth ;
        }

    }
})();
