define([
    'jQuery',
    'Angular',
    'Lodash',
    'AngularUiRouter',
    'AngularXEditable',
    'Bootbox',
    'app/service/HouseService'
], function ($, angular, _, angularUiRouter, angularXEditable, Bootbox, houseService) {
    var module = angular.module('houses.controller.house', [
        'ui.router',
        'xeditable',
        'houses.service.house'
    ]);

    module.config(['$stateProvider', function ($stateProvider) {
        $stateProvider.state('house', {
            url: '/house/:houseId',
            templateUrl: 'resources/templates/controller/house.html',
            controller: 'HouseController',
            header: 'House',
            icon: 'building'
        });
    }]);
    
    module.run(function(editableOptions) {
    	  editableOptions.theme = 'bs3';
	});

    module.controller('HouseController', ['$scope', '$rootScope', '$compile', '$state', 'HouseService',
        function ($scope, $rootScope, $compile, $state, houseService) {
            
    		houseService.get({id: $state.params.houseId}, function (house) {
                $scope.house = house
            });
    		
    		$scope.checkName = function(name) {    			
    			if (isEmpty(name)) {
    				return "House name cannot be empty!";
    			}          
    		}
    		
    		$scope.checkAddress = function(address) {    			
    			if (isEmpty(address)) {
    				return "House address cannot be empty!";
    			}          
    		}
    		
    		$scope.updateHouse = function(house) {    			
    			houseService.update(house, function (house) {
    				//do nothing on successful update
                }, function (error) {
                    alert('Error: ' + error.status)
                });            
    		}
                
            $scope.setTenant = function (room) {
                var $dialogScope = $scope.$new();
                Bootbox.dialog({
                    message: $compile('<input type="text" class="form-control" ng-model="tenant"/>')($dialogScope),
                    title: 'Set tenant',
                    buttons: {
                        cancel: {
                            label: 'Cancel'
                        },
                        set: {
                            label: 'Set',
                            callback: function () {
                                room.tenant = $dialogScope.tenant;
                                $scope.$apply()
                            }
                        }
                    }
                });
            };

            $scope.removeTenant = function (room) {
                room.tenant = null;
            };

            $scope.deleteRoom = function (floor, room) {
                floor.rooms.splice(floor.rooms.indexOf(room), 1);
                if (floor.rooms.length === 0) {
                    doAddRoom(floor)
                }
            };

            var doAddFloor = function () {
                const floor = {};
                $scope.house.floors.push(floor);
                doAddRoom(floor);
            };

            $scope.addFloor = function () {
                doAddFloor()
            };

            var doAddRoom = function (floor) {
                if (!floor.rooms) {
                    floor.rooms = []
                }
                floor.rooms.push({
                    name: '1'
                })
            };

            $scope.addRoom = function (floor) {
                doAddRoom(floor)
            };

            $scope.tenantString = function (room) {
                var tenant = room.tenant;
                if (!tenant) {
                    return 'Vacant'
                }
                return tenant.length > 10 ? tenant.substr(0, 7) + '...' : tenant
            };

            $scope.removeFloor = function(floor) {
                $scope.house.floors.splice($scope.house.floors.indexOf(floor), 1);
                if ($scope.house.floors.length === 0) {
                    doAddFloor()
                }
            }; 
            
            function isEmpty(str) {
                return (!str || 0 === str.length);
            };
        }
    ]);
});