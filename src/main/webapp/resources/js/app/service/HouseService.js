define([
    'jQuery',
    'Angular',
    'AngularResource'
], function ($, angular) {
    var module = angular.module('houses.service.house', ['ngResource']);

    module.factory('HouseService', ['$resource', function ($resource) {
        return $resource('api/house/', {},
            {
                get: {
                    method: 'GET',
                    isArray: true
                },
                add: {
                    method: 'POST'
                }
            }
        )
    }]);
});