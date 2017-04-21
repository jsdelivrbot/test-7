(function() {
    'use strict';

    angular
        .module('gwApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', '$rootScope','Principal', 'LoginService','ProjectsService','StorageDataService','GitlabToken','GitlabInfo','GLUserService','GitlabErrorService','$state','$window','$location','$timeout'];

    function HomeController ($scope, $rootScope, Principal, LoginService,ProjectsService, StorageDataService, GitlabToken, GitlabInfo, GLUserService,GitlabErrorService, $state, $window, $location, $timeout) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;

        
        vm.loginGitlab = loginGitlab;
        //vm.gitlabLogout = gitlabLogout;
        vm.getToken = getToken;
        vm.isAuthenticatedGitlab = false;
        vm.getAllProjects = getAllProjects;
        vm.gitlabAccount = null;


        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }
        function register () {
            $state.go('register');
        }
        $rootScope.$on('$stateChangeStart', 
        function(event, toState, toParams, fromState, fromParams, options){ 
          if(StorageDataService.getGitlabAuth()==false){
            if(toState.name!="home"){
                event.preventDefault();
                console.log("preventDefault 1");
            }
          }
          

        });
        //------------------------------------------------------------------------------------------------------
        /*
Function_ getCodeFromURL Detectar si hay parametros i.e cuando se redirecciona del server oauth

        */
        $scope.$watch(function() { 
            
            
        }, function(value){
            //console.log($location.protocol() + "://" + $location.host() + ":" + $location.port());
            $location.$$search = {};
            getCodeFromURL();
            if(StorageDataService.getGitlabToken()!=null && StorageDataService.getGitlabToken()!=undefined){
                console.log("I have a token");
                vm.gitlabAccount = StorageDataService.getGLUser();                
            }else{
                if(StorageDataService.getGitlabCode()!=null){
                    getToken();
                }
                console.log("I haven't a token");
                 
            }
            vm.isAuthenticatedGitlab = StorageDataService.getGitlabAuth();

        });

/**Esta funcion solo aparece cuando el usuario no esta logeado y necesita saber si necesita ir o no por el token */
        function loginGitlab(){
            console.log("loginGitlab");
            if(StorageDataService.getGitlabToken()!=null && StorageDataService.getGitlabToken()!=undefined){
                 vm.isAuthenticatedGitlab = true;
                 StorageDataService.setGitlabAuth(true);
                 $state.reload();

            }else{
                GitlabInfo.get(null,onSuccessInfo, onErrorInfo);
            }


        };
         function getToken(){
                var result_params = {};
                result_params['code'] = StorageDataService.getGitlabCode();
                GitlabToken.get(result_params,onSuccessToken, onErrorToken);
        }
        function getAllProjects(){
            ProjectsService.get({"token":StorageDataService.getGitlabToken()},onSuccessProjects, onErrorProjects);   
        }

        function getCodeFromURL(){
            var result_params = {};
            var params = $window.location.search;
            var param1 = "?code=";
            var param2 = "&state=";
            if(params.indexOf('code')>=0){
                var code=params.substring(params.lastIndexOf(param1)+param1.length,params.lastIndexOf(param2));                
                StorageDataService.setGitlabCode(code);
            }
        }

        function onSuccessToken(data, headers){
            
            StorageDataService.setGitlabToken(data.access_token);
            
            console.log("ONSUCCEsS token "+JSON.stringify(data));
            vm.isAuthenticatedGitlab = true;
            StorageDataService.setGitlabAuth(true);
            GLUserService.get({"token":StorageDataService.getGitlabToken()},onSuccessUser, onErrorUser);   
            
        }
        function onErrorToken(error){
            vm.isAuthenticatedGitlab = false;
            StorageDataService.setGitlabAuth(false);
            console.log("onerror");
            StorageDataService.setGitlabToken(null);
        }
        function onSuccessInfo(data, headers){

            console.log("info"+JSON.stringify(data));
            console.log("info"+JSON.stringify(headers));
            StorageDataService.setRequestInfo(data);
                    
            var url=data.authorizeURL+"?client_id="+data.clientId+"&redirect_uri="+data.redirectURI+
            "&response_type="+data.responseType+'&state='+data.state;

            window.location.replace(url);
        }
        function onErrorInfo(error){
            StorageDataService.setRequestInfo(null);
            console.log("onerror info");
        }
        function onSuccessProjects(response){
            StorageDataService.setProjects(response);
            console.log("success projects info");
            $state.go("projects");
        }
        function onErrorProjects(error){
             console.log("onerror projects info");
             //$state.go("error");
             GitlabErrorService.open();
             StorageDataService.clearSession();
             $state.reload();
        }
        function onSuccessUser(response){
            StorageDataService.setGLUser(response);
            console.log("onSuccessUser");
            vm.gitlabAccount = response;
            vm.isAuthenticatedGitlab = true;
            StorageDataService.setGitlabAuth(true);
            $state.reload();
        }
        function onErrorUser(error){
            console.log("onErrorUser");
            //$state.go("error");
            GitlabErrorService.open();
            StorageDataService.clearSession();
            $state.reload();
        }
        
    }
})();


