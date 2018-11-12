'use strict';

angular.module('ActivosApp').controller('ActivoController',
    ['ActivoService','LoginService', '$scope',  function( ActivoService, LoginService, $scope) {

        var self = this;
        self.activos=[];

        self.getAllActivos = getAllActivos;

        self.successMessage = '';
        self.errorMessage = '';

        function getAllActivos(){
            return formatActivos(ActivoService.getAllActivos());
        }

        function formatActivos(data){
            var activosF = [];
            for(var i in data)
            {
                activosF.push({
                    "fechaCompra"   : data[i].fechaCompra,
                    "valorCompra"       : data[i].valorCompra,
                    "nombre"         : data[i].nombre,
                    "serial"   : data[i].serial,
                    "estado"      : data[i].estado,
                    "tipo"      : data[i].tipo
                });
            }
            return activosF;
        }


    }

]);