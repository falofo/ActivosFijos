'use strict';

angular.module('ActivosApp').factory('LoginService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                getJWT: getJWT
            };

            return factory;

            function getJWT() {
                console.log('Obteniendo jwt');
                var deferred = $q.defer();
                var user = "admin";
                var pass = "admin";
                var data = {
                    'user':user,
                    'password':pass
                }
                $http.post(urls.LOGIN_SERVICE_API,data)
                    .then(
                        function (response) {
                            console.log('JWT obtenido satisfactoriamente');
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error obteniendo JWT');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);