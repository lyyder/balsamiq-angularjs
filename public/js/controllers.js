'use strict';

/* Controllers */

app.controller('beerController', function($scope, beerService){

    $scope.model = beerService;
    beerService.getBeers();

    $scope.addBeer = function () {
        beerService.update($scope.model.beer);
        $scope.model.beer = {};
    }

    $scope.remove = function (id) {
        console.log(id);
        beerService.remove(id);
    }

    $scope.modify = function (index) {
        $scope.model.beer = $scope.model.beers[index];
    }

    $scope.reset = function (index) {
        $scope.model.beer = {};
    }

});
