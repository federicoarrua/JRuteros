<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Rutas</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="clasesJruteros.Ruta" %>
	<%@ page import="java.sql.Time" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<form class="navbar-form navbar-left" action="#" role="buscar">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="Buscar por criterio...">
		  </div>
		  <select name="criterio" required>
		  	  <option value="">--Criterio--</option>
	          <option value="nombre">Nombre</option>
	          <option value="actividad">Actividad</option>
	          <option value="distancia">Distancia</option>
			  <option value="tiempo">Tiempo</option>	
		  </select>
		  <button type="submit" class="btn btn-default">Buscar</button>
		</form>
		<br><br>
		<table class="table">
			<thead>
				<tr>
					<td>Ruta</td>
					<td>Tipo de actividad</td>
					<td>Tiempo Estimado</td>
					<td>Dificultad</td>
					<td>Formato</td>
					<td>Distancia</td>
				</tr>
			</thead>
			<tbody>
				<% HashMap<String,Ruta> rutas = (HashMap<String,Ruta>)application.getAttribute("rutas"); %>
				<% for(String key : rutas.keySet()) { %>
					<tr>
						<% Ruta r = rutas.get(key); %>
						<td><a href="mostrarruta?ruta=<%= r.getNombre() %>"><%= r.getNombre() %></a></td>
						<td><%= r.getActividad()%></td>
						<td><%= r.getTiempoEstimado().toString() %></td>
						<td><%= r.getDificultad().toString() %></td>
						<td><%= r.getFormato().toString() %></td>
						<td><%= r.getDistancia() %> KM</td>
					</tr>
				<% } %>

			</tbody>
		</table>
	</div>
</body>
</html>