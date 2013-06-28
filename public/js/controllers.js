'use strict';

/* Controllers */

app.controller('beerController', function($scope, beerService){

    $scope.beers = beerService.getBeers();

    $scope.addBeer = function () {
        beerService.addBeer($scope.beer);
    }

});
