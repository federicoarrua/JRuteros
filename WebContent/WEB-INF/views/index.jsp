<html>
<head>
	<meta charset="UTF-8">
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<title>JRuteros</title>
	<script>
	    $(document).ready(function(){
	        var date_input=$('input[name="date"]'); //our date input has the name "date"
	        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
	        date_input.datepicker({
	            format: 'mm/dd/yyyy',
	            container: container,
	            todayHighlight: true,
	            autoclose: true,
	        })
	    })
	</script>
</head>
<body background="images/background.jpg">
	
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      
	      <a class="navbar-brand" href="inicio">
	      	<img style="max-width:100px; margin-top: -7px;" src="images/icono navbar2.png">
	      </a>
	    </div>
	    
	    <form class="navbar-right navbar-form" role="login" action="/jruteros/loginusr" method="POST">
	    	
	    	<% if(request.getAttribute("errorLogin") == null){ %>
		    	<div class="form-group">
		    		<input type="text" name="user" class="form-control" placeholder="Usuario"/>
		    		<input type="password" name="password" class="form-control" placeholder="Password"/>
		    	</div>
		    <% } else { %>
		    	<div class="form-group has-error">
		    		<input type="text" data-placement="bottom"title="Usuario y/o contraseña incorrectos" data-toggle="tooltip" name="user" class="form-control" placeholder="Usuario" required/>
		    		<input type="password" name="password" class="form-control" placeholder="Password" required/>
		    	</div>
		    <% } %>
	    	<button type="submit" class="btn btn-default">Entrar</button>
	    </form><!-- /.navbar-form -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<div class="col-md-6">
	      <img src="images/Solo.png">
	      <p>JRuteros es un proyecto creado para unir viajeros de todas partes.</p>
	      <p>Permite a sususuarios encontrar, subir y compartir rutas al aire libre</p>
	</div>
	
	<div class="col-md-6">
		<h2>Registrarse</h2>
		<form action="regusr" method="POST" data-toggle="validator">
			
			<div class="form-group">
				<% if(request.getAttribute("errorReg") == null){ %>
					<div class="input-group">
						<input type="text" name="username" class="form-control" placeholder="Nombre de usuario" pattern=".{5,10}" required title="De 5 a 12 caracteres" required>
					</div>
				<% }else{ %>
					<div class="input-group has-error">
						<input type="text" title="El nombre de usuario ya existe"data-toggle="tooltip"name="username" class="form-control" placeholder="Nombre de usuario" pattern=".{5,10}" required title="De 5 a 12 caracteres" required>
					</div>
				<% } %>
			</div>
			<div class="form-group">
				<div class="input-group">
				<input type="text" name="nombre" class="form-control" placeholder="Nombre" required>
				<span class="input-group-btn" style="width:4px;"></span>
				<input type="text" name="apellido" class="form-control" placeholder="Apellido" required>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group">
					<input type="number" name="dni" min="1" class="form-control" placeholder="DNI" required>
					<span class="input-group-btn" style="width:4px;"></span>
				</div>
			</div>
			
			<div class="form-group">
					<input type="email" name="email" class="form-control" placeholder="E-mail" required>
			</div>
			
			<div class="form-group">
					<input type="text" name="direccion" class="form-control" placeholder="Domicilio" required>
			</div>
            <div class="form-group"> <!-- Date input -->
		        <input class="form-control" id="date" name="date" placeholder="Fecha de nacimiento MM/DD/YYYY" type="text"/>
      		</div>
			<div class="form-group">
			    <button type="submit" class="btn btn-default">Registrarse</button>
			</div>
		</form>
	</div>
	

</body>
</html>