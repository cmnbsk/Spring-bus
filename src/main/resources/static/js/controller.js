app.controller('busController', ["$scope","$location","$routeParams", function($scope,$location,$routeParams) {
    $scope.addBus = function () {
        $location.path("/bus");
    }
}
]);

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles List";
});
