define([
    'jQuery',
    'Angular',
    'AngularResource'
], function ($, angular) {
    var module = angular.module('houses.service.login', ['ngResource']);

    module.factory('LoginService', ['$resource', function ($resource) {
        return $resource(':action', {},
            {
                authenticate: {
                    method: 'POST',
                    params: {'action' : 'authenticate'},
                    headers : {'Content-Type': 'application/x-www-form-urlencoded'}
                }
            }
        );
    }]);
});