'use strict';

/* Directives */


app.directive('enter', function() {
  return function(scope, element, attrs){
      element.bind('mouseover', function() {
          element.addClass(attrs.enter);
      });
    }
});

app.directive('leave', function() {
  return function(scope, element, attrs) {
    element.bind('mouseleave', function() {
      element.removeClass(attrs.enter);
    });
  }
});