var app = angular.module('ActivosApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:9000/activos',
    ACTIVO_SERVICE_API : 'http://localhost:9000/activos/api/v1/activo',
    LOGIN_SERVICE_API : 'http://localhost:9000/activos/login'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
               url: '/',
               templateUrl: 'partials/list',
               controller:'ActivoController',
               controllerAs:'ctrl',
               resolve: {
                   activos: function ($q, ActivoService) {
                       console.log('Cargar todos los activos');
                       var deferred = $q.defer();
                       ActivoService.loadAllActivos().then(deferred.resolve, deferred.resolve);
                       return deferred.promise;
                   }
               }
            });
        $urlRouterProvider.otherwise('/');
    }]);

