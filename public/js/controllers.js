'use strict';

/* Controllers */

app.controller('beerController', function($scope, beerService){

    $scope.model = beerService;
    beerService.getBeers();

    $scope.addBeer = function () {
        beerService.update($scope.model.beer);
        $scope.model.beer = {};
    }

});
