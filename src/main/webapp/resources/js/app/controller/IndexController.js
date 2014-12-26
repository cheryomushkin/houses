define([
    'jQuery',
    'Angular',
    'Lodash',
    'AngularUiRouter',
    'Bootbox',
    'app/service/HouseService'
], function ($, angular, _, angularUiRouter, Bootbox, houseService) {
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

    module.controller('IndexController', ['$scope', '$rootScope', '$compile', 'HouseService',
        function ($scope, $rootScope, $compile, houseService) {
            $scope.houses = houseService.get();
            $scope.addNew = function () {
                var $dialogScope = $scope.$new();
                Bootbox.dialog({
                    message: $compile('<input type="text" class="form-control" ng-model="name"/>')($dialogScope),
                    title: 'Add new house',
                    buttons: {
                        cancel: {
                            label: 'Cancel'
                        },
                        create: {
                            label: 'Create',
                            callback: function () {
                                houseService.add({name: $dialogScope.name}, function (house) {
                                    $scope.houses.push(house)
                                }, function (error) {
                                    alert('Error: ' + error.status)
                                })
                            }
                        }
                    }
                });
            };

            $scope.remove = function (house) {
                Bootbox.confirm('Are you sure?', function (result) {
                    if (result) {
                        houseService.delete({id: house.id}, function() {
                            _.remove($scope.houses, function(it) {
                                return it.id === house.id;
                            });
                        })
                    }
                })
            }
        }
    ]);
});