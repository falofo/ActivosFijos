<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"></span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de activos </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Nombre</th>
		                <th>Fecha Compra</th>
		                <th>Valor $</th>
		                <th>Serial</th>
		                <th>Estado</th>
		                <th>Tipo</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="activo in ctrl.getAllActivos()">
		                <td>{{activo.nombre}}</td>
		                <td>{{activo.fechaCompra | date:'dd-MM-yyyy'}}</td>
		                <td>$ {{activo.valorCompra.toFixed(2)}}</td>
		                <td>{{activo.serial}}</td>
		                <td>{{activo.estado}}</td>
		                <td>{{activo.tipo}}</td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>