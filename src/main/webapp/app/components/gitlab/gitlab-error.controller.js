(function() {
    'use strict';

    angular
        .module('gwApp')
        .controller('GitlabErrorController', GitlabErrorController);

    GitlabErrorController.$inject = ['$rootScope', '$state', '$timeout', 'Auth', '$uibModalInstance'];

    function GitlabErrorController ($rootScope, $state, $timeout, Auth, $uibModalInstance) {
        var vm = this;
        
        vm.cancel = cancel;
        

        function cancel () {
            vm.credentials = {
                username: null,
                password: null,
                rememberMe: true
            };
            vm.authenticationError = false;
            $uibModalInstance.dismiss('cancel');
        }

        
    }
})();
