<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Rutas</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ include file="/WEB-INF/layouts/dataTables.html" %>
	<%@ page import="java.util.HashMap" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="clasesJruteros.Ruta" %>
	<%@ page import="java.sql.Time" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<form class="navbar-form navbar-left" action="#" role="buscar">
		  <div class="form-group">
		    <input type="nombe" class="form-control" placeholder="Filtrar por nombre..">
		  </div>
		  <div class="form-group">
		    <input type="distancia" class="form-control" placeholder="Filtrar por distancia..">
		  </div>
		  <div class="form-group">
		    <input type="tiempo" class="form-control" placeholder="Filtrar por tiempo..">
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
		  <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-map-marker"></span> Buscar por cercanía</button>
		</form>
		
		<table id="sort" class="table table-condensed">
			<thead>
				<tr>
					<td data-field="ruta">Ruta</td>
					<td class="text-center">Tipo de actividad</td>
					<td class="text-center">Tiempo Estimado</td>
					<td class="text-center">Dificultad</td>
					<td class="text-center">Formato</td>
					<td class="text-center">Distancia</td>
				</tr>
			</thead>
			<tbody>
				<% HashMap<String,Ruta> rutas = (HashMap<String,Ruta>)application.getAttribute("rutas"); %>
				<% for(String key : rutas.keySet()) { %>
					<tr>
						<% Ruta r = rutas.get(key); %>
						<td><a href="mostrarruta?ruta=<%= r.getNombre() %>"><%= r.getNombre() %></a></td>
						<td class="text-center"><%= r.getActividad()%></td>
						<td class="text-center"><%= r.getTiempoEstimado().toString() %></td>
						<td class="text-center"><%= r.getDificultad().toString() %></td>
						<td class="text-center"><%= r.getFormato().toString() %></td>
						<td class="text-center"><%= r.getDistancia() %> KM</td>
					</tr>
				<% } %>

			</tbody>
		</table>
	</div>
</body>
</html>