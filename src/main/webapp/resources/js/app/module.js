define([
    'jQuery',
    'Angular',
    'AngularCookies',
    'app/controller/IndexController',
    'app/service/LoginService'
], function ($, angular, indexController, loginService) {
    'use strict';
    var module = angular.module('houses', [
        'ngCookies',
        'houses.controller.index',
        'houses.service.login'
    ]).config(function ($stateProvider, $urlRouterProvider, $locationProvider) {
        $urlRouterProvider.otherwise('/index');
        $locationProvider.html5Mode(true);
        $locationProvider.hashPrefix('!');
    });

    //todo move it in proper place
    var xAuthTokenHeaderName = 'x-auth-token';
    
    module.controller('AppController', ['$scope', '$rootScope', '$http', '$cookieStore', 'LoginService',
        function ($scope, $rootScope, $http, $cookieStore, loginService) {
            $rootScope._app = {
                initialized: false
            };
            $rootScope._page = {
                header: '',
                icon: ''
            };

            $rootScope.hasRole = function(role) {
                if ($rootScope.user === undefined) return false
                if ($rootScope.user.roles[role] === undefined) return false
                return $rootScope.user.roles[role]
            };

            $rootScope.logout = function() {
                delete $rootScope.user
                delete $http.defaults.headers.common[xAuthTokenHeaderName]
                $cookieStore.remove('user')
            };
            
            $scope.login = function() {
                loginService.authenticate($.param({username: $scope.username, password: $scope.password}), function(user) {
                    $rootScope.user = user
                    $http.defaults.headers.common[ xAuthTokenHeaderName ] = user.token
                    $cookieStore.put('user', user)
                });
            };

            var user = $cookieStore.get('user');
            if (user !== undefined) {
                $rootScope.user = user;
                $http.defaults.headers.common[xAuthTokenHeaderName] = user.token;
            }

            $rootScope._app.initialized = true;
            $('.nav-container').show()
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





