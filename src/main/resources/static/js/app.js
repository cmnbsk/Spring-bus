var app = angular.module('Spring-bus', ["ngRoute"]);
app.config(function($routeProvider){
    $routeProvider
        .when('/busform',{
            templateUrl: '/bus.html',
            controller: 'busController'
        })
        .when('/companyform',{
            templateUrl: '/company.html',
            controller: 'companyController'
        })
        .when('/courseform',{
            templateUrl: '/course.html',
            controller: 'courseController'
        })
        .when('/customerform',{
            templateUrl: '/customer.html',
            controller: 'customerController'
        })
        .when('/stationform',{
            templateUrl: '/station.html',
            controller: 'stationController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});

