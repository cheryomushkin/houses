define([
    'jQuery',
    'Angular',
    'app/controller/IndexController'
], function ($, angular, indexController) {
    'use strict';
    var module = angular.module('houses', [
        'houses.controller.index'
    ]).config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
        $urlRouterProvider.otherwise('/index');
        $locationProvider.html5Mode(true);
        $locationProvider.hashPrefix('!');
    });

    module.controller('AppController', ['$scope', '$rootScope',
        function ($scope, $rootScope) {
            $rootScope._app = {
                initialized: false
            };
            $rootScope._page = {
                header: '',
                icon: ''
            };
            $rootScope._app.initialized = true;
            $('.main-container').show()
        }
    ]);

    module.run(['$rootScope', function($rootScope) {
        $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
            $rootScope._page.header = toState.header;
            $rootScope._page.icon = toState.icon;
        });
    }]);

    $(document).ready(function () {
        angular.bootstrap($('html'), ['houses']);
    });
});





