<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Usuarios</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<script src="bootstrap/data table/js/jquery.dataTables.js"></script>
	<script src="bootstrap/data table/js/dataTables.bootstrap.js"></script>
	<link href="bootstrap/data table/css/dataTables.bootstrap.css" rel="stylesheet" />
	<script>$(document).ready(function() {
		$('table').dataTable({bInfo: false});
		$('#sort').dataTable();
	});</script>
	<%@ page import="java.util.HashMap" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<table id="sort" class="table table-condensed">
			<thead>
				<tr>
					<td class="text-center">Usuario</td>
					<td class="text-center">Nombre</td>
					<td class="text-center">E-mail</td>
					<td class="text-center">Edad</td>
					<td data-sortable="false" class="text-center">Habilitar/Deshabilitar</td>
				</tr>
			</thead>
			<tbody>
				<% HashMap<String,Usuario> usuarios = (HashMap<String,Usuario>)application.getAttribute("usuarios"); %>
				<% for(String key : usuarios.keySet()) { %>
					<tr>
						<% u = usuarios.get(key); %>
						<td><a href="mostrarusuario?usuario=<%= u.getUsername() %>"><%= u.getUsername() %></a></td>						<td class="text-center"><%= u.getNombres() %> <%=u.getApellido() %></td>
						<td class="text-center"><%= u.getEmail() %></td>
						<td class="text-center">23</td>
						<td class="text-center"><button class="btn btn-xs btn-warning">Deshabilitar</button></td>
					</tr>
				<% } %>
					<tr>
						<td class="text-center">user5</td>
						<td class="text-center">nombre5 apellido5</td>
						<td class="text-center">user5@mail.com</td>
						<td class="text-center">23</td>
						<td class="text-center"><button class="btn btn-xs btn-default">Habilitar</button></td>
					</tr>
			</tbody>
		</table>
	</div>
</body>
</html>