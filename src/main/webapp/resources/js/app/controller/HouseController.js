define([
    'jQuery',
    'Angular',
    'Lodash',
    'AngularUiRouter',
    'Bootbox',
    'app/service/HouseService'
], function ($, angular, _, angularUiRouter, Bootbox, houseService) {
    var module = angular.module('houses.controller.house', [
        'ui.router',
        'houses.service.house'
    ]);

    module.config(['$stateProvider', function ($stateProvider) {
        $stateProvider.state('house', {
            url: '/house/:houseId',
            templateUrl: 'resources/templates/controller/house.html',
            controller: 'HouseController',
            header: 'House page'
        });
    }]);

    module.controller('HouseController', ['$scope', '$rootScope', '$compile', '$state', 'HouseService',
        function ($scope, $rootScope, $compile, $state, houseService) {
            houseService.get({id: $state.params.houseId}, function(house) {
                $scope.house = house
            });
        }
    ]);
});