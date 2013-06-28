'use strict';

/* Services */


// Demonstrate how to register services
// In this case it is a simple value service.
angular.module('myApp.services', []).
    value('version', '0.1');


postsApp.service('PostsService', function ($http) {



    return {
        get : function() {console.log("get");
            return [
                {
                    author: "Bob",
                    msg: "surf safe"
                },
                {
                    author: "Alice",
                    msg: "Will do"
                },
                {
                    author: "Eve",
                    msg: "No you dont"
                }
            ];
        }
    }


        //$http.get('/api/posts').success(function (data) {





        //});


});