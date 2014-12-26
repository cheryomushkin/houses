define([
    'jQuery',
    'Angular',
    'Lodash',
    'AngularUiRouter',
    'Bootbox',
    'app/controller/HouseController',
    'app/service/HouseService'
], function ($, angular, _, angularUiRouter, Bootbox) {
    var module = angular.module('houses.controller.index', [
        'ui.router',
        'houses.controller.house',
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
            $scope.houses = houseService.getAll();
            $scope.addNew = function () {
                var $dialogScope = $scope.$new();
                Bootbox.dialog({
                    message: $compile('<form role="form">' +
                        '<div class="form-group"><input type="text" placeholder="Name" class="form-control" ng-model="name"/></div>' +
                        '<div class="form-group"><input type="text" placeholder="Address" class="form-control" ng-model="address"/></div>' +
                        '</form>')($dialogScope),
                    title: 'Add new house',
                    buttons: {
                        cancel: {
                            label: 'Cancel'
                        },
                        create: {
                            label: 'Create',
                            callback: function () {
                                houseService.add({name: $dialogScope.name, address: $dialogScope.address}, function (house) {
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