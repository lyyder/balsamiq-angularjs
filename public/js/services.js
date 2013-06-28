'use strict';

/* Services */


app.factory('beerService', function (beerResource) {

    var factory = new function() {
        this.beers = [];
    };

    factory.getBeers = function() {
        beerResource.all(function(result) {
            console.log("all: " + result);
            factory.beers = result;
        });
    };

    factory.update = function (beer) {
        beerResource.update(beer, function(result){
            console.log("updated: " + result);
            factory.getBeers();
        });
    };

    factory.remove = function (id) {
        beerResource.remove({id: id}, function(result) {
            console.log("removed: " + result);
            factory.getBeers();
        });
    };

//    this.getWorker = function (index) {
//        return workers[index];
//    };


    return factory;

});