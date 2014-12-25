define([
    'jQuery',
    'Angular',
    'AngularUiRouter',
    'app/service/HouseService'
], function ($, angular, angularUiRouter, houseService) {
    var module = angular.module('houses.controller.index', [
        'ui.router',
        'houses.service.house'
    ]);

    module.config(['$stateProvider', function ($stateProvider) {
        $stateProvider.state('index', {
            url: '/index',
            templateUrl: 'resources/templates/controller/index.html',
            controller: 'IndexController',
            header: 'City page'
        });
    }]);

    module.controller('IndexController', ['$scope', '$rootScope', 'HouseService',
        function ($scope, $rootScope, houseService) {
            $scope.houses = houseService.get()
        }
    ]);
});