(function () {
    'use strict';

    angular
        .module('gwApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('uaa/api/register', {}, {});
    }
})();
