'use strict';

angular.module('ActivosApp').factory('ActivoService',
    ['LoginService','$localStorage', '$http', '$q', 'urls',
    function (LoginService,$localStorage, $http, $q, urls) {

        var factory = {
            getAllActivos: getAllActivos,
            loadAllActivos: loadAllActivos
        };

        return factory;

        function loadAllActivos() {
            var jwt = LoginService.getJWT();
            var deferred = $q.defer();
            jwt.then(function(data){
                console.log('Obteniendo activos');

                $http.get(urls.ACTIVO_SERVICE_API,{headers:{
                    'Authorization' : 'Bearer '+ data.data
                }}).then(
                        function (response) {
                            console.log('Activos obtenidos satisfactoriamente');
                            $localStorage.activos = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error cargando activos');
                            $localStorage.activos = [];
                            deferred.reject(errResponse);
                        }
                    );
            })

            return deferred.promise;
        }

        function getAllActivos(){
            return $localStorage.activos;
        }

    }
]);