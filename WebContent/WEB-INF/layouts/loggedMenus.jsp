<%@page import="clasesJruteros.Usuario"%>

<% Usuario u= (Usuario) request.getSession().getAttribute("usuario"); %>
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
	    
	    <ul class="nav navbar-nav navbar-right">
	    <li ><a href="inicio">Inicio</a></li>
        <li class="dropdown ">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= u.getNombres() %> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Modificar Datos</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="salir">Salir</a></li>
          </ul>
        </li>
      </ul>
	    
	</div><!-- /.container-fluid -->
</nav>

<div class="col-md-2 col-xs-3 list-group">
 
 	<% if(request.getSession().getAttribute("admin") == null) { %>
		<a class="list-group-item" href="listarrutas">Buscar Rutas</a>
		<a class="list-group-item" href="misrutas">Mis Rutas</a>
		<a class="list-group-item" href="subirRuta">Subir Ruta</a>
	<% } else { %>	
		<a class="list-group-item" href="verusuarios">Ver Usuarios</a>
		<a class="list-group-item" href="actividades">Modificar Actividades</a>
		<a class="list-group-item" href="estadisticas">Ver estadisticas</a>
	<% } %>
</div>
