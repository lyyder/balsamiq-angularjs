app.factory('beerResource', function($resource) {
return $resource("/beers/:id", {id: "@id"}, {
    get: {method: "GET"},
    all: {method: "GET", isArray : true},
    update: {method: "PUT"}
  });
});