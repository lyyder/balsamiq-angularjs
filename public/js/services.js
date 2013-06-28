'use strict';

/* Services */


app.factory('beerService', function (beerResource) {

    var factory = (function() {
        var instance = {};

        instance.beers = [];

        return instance;
    })();

    factory.getBeers = function() {
        beerResource.all(function(result) {
            console.log("all: " + result);
            factory.beers = result;
        });
    };

    factory.update = function (beer) {
        if(!beer.id) {
            beer.id = factory.beers.length + 1;
            console.log(beer.id);
        }
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