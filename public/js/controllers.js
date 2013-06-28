'use strict';

/* Controllers */

postsApp.controller('PostsCtrl', function($scope, $http, PostsService){

    $scope.posts = PostsService.get().reverse();
    console.log("posts: " + $scope.posts)

    $scope.addPost = function () {

        $scope.posts.push($scope.post)
        $scope.post = {};
    }

});
