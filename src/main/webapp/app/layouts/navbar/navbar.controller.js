(function() {
    'use strict';

    angular
        .module('gwApp')
        .controller('NavbarController', NavbarController);

    NavbarController.$inject = ['$state', 'Auth', 'Principal', 'ProfileService', 'LoginService','StorageDataService'];

    function NavbarController ($state, Auth, Principal, ProfileService, LoginService, StorageDataService) {
        var vm = this;

        vm.isNavbarCollapsed = true;
        vm.isAuthenticated = Principal.isAuthenticated;

        ProfileService.getProfileInfo().then(function(response) {
            vm.inProduction = response.inProduction;
            vm.swaggerEnabled = response.swaggerEnabled;
        });

        vm.login = login;
        vm.logout = logout;
        vm.toggleNavbar = toggleNavbar;
        vm.collapseNavbar = collapseNavbar;
        vm.$state = $state;

        vm.isAuthenticatedGitlab = StorageDataService.getGitlabAuth();
        vm.gitlabLogout = gitlabLogout;

        function login() {
            collapseNavbar();
            LoginService.open();
        }

        function logout() {
            collapseNavbar();
            Auth.logout();
            $state.go('home');
        }

        function toggleNavbar() {
            vm.isNavbarCollapsed = !vm.isNavbarCollapsed;
        }

        function collapseNavbar() {
            vm.isNavbarCollapsed = true;
        }
        function gitlabLogout(){
            collapseNavbar();
            console.log("logout");
            StorageDataService.setGitlabAuth(false);
            vm.isAuthenticatedGitlab = false;
            //$state.reload();
            console.log($state.current.name);
            if($state.current.name=="home"){
                $state.reload();
            }else{
                $state.go('home');
            }
        }
    }
})();
