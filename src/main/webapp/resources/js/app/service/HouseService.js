define([
    'jQuery',
    'Angular',
    'AngularResource'
], function ($, angular) {
    var module = angular.module('houses.service.house', ['ngResource']);

    module.factory('HouseService', ['$resource', function ($resource) {
        return $resource('api/house/:id', {id: '@id'},
            {
                getAll: {
                    method: 'GET',
                    isArray: true
                },
                get: {
                    method: 'GET',
                    params: {
                        id: '@id'
                    }
                },
                add: {
                    method: 'POST'
                },
                update: {
                    method: 'PUT'
                },
                delete: {
                    method: 'DELETE',
                    params: {
                        id: '@id'
                    }
                }
            }
        )
    }]);
});