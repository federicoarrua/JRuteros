<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Mis Rutas</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ include file="/WEB-INF/layouts/dataTables.html" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="clasesJruteros.Ruta" %>
	<%@ page import="java.sql.Time" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-10">
		<h3>Mis Rutas</h3>
		<form class="navbar-form navbar-left" action="#" role="buscar">
		  <div class="form-group">
		    <input type="nombe" class="form-control" placeholder="Filtrar por nombre..">
		  </div>
		  <div class="form-group">
		    <input type="distancia" class="form-control" placeholder="Filtrar por distancia..">
		  </div>
		  <div class="form-group">
		    <input type="tiempo" class="form-control" placeholder="Filtar por tiempo..">
		  </div>
		  <div class="form-group">
				<select class="form-control" name="actividad">
					<option value="">--Filtrar por actividad--</option>
					<% ArrayList<String> acts = (ArrayList<String>)application.getAttribute("actividades"); %>
					<% for(int i=0;i<acts.size();i++){ %>
						<option value="<%= acts.get(i)%>"><%= acts.get(i) %></option>
					<% } %>
				</select>
			</div>
		  <button type="submit" class="btn btn-default">Buscar</button>
		</form>
		<br><br>
		<table id="sort" class="table table-condensed">
			<thead>
				<tr>
					<td>Ruta</td>
					<td class="text-center">Tipo de actividad</td>
					<td class="text-center">Tiempo Estimado</td>
					<td class="text-center">Dificultad</td>
					<td class="text-center">Formato</td>
					<td data-sortable="false" class="text-center">Distancia</td>
					<td data-sortable="false" class="text-center">Editar</td>
					<td data-sortable="false" class="text-center">Eliminar</td>
				</tr>
			</thead>
			<tbody>
				<% ArrayList<Ruta> misrutas = (ArrayList<Ruta>)request.getAttribute("misrutas"); %>
				<% for(int i=0;i<misrutas.size();i++) { %>
					<tr>
						<% Ruta r = misrutas.get(i); %>
						<td><a href="mostrarruta?ruta=<%= r.getNombre() %>"><%= r.getNombre() %></a></td>
						<td class="text-center"><%= r.getActividad()%></td>
						<td class="text-center"><%= r.getTiempoEstimado().toString() %></td>
						<td class="text-center"><%= r.getDificultad().toString() %></td>
						<td class="text-center"><%= r.getFormato().toString() %></td>
						<td class="text-center"><%= r.getDistancia() %> KM</td>
						<td class="text-center"><a href="editarRuta.jsp?nombre=<%= r.getNombre() %>"><button class="btn btn-sm btn-primary">Editar</button></a></td>
						<td class="text-center"><button class="btn btn-sm btn-danger">Eliminar</button></td>
					</tr>
				<% } %>

			</tbody>
		</table>
	</div>
</body>
</html>