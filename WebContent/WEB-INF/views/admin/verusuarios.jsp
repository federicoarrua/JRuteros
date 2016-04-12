<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Usuarios</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="java.util.HashMap" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<table class="table table-condensed">
			<thead>
				<tr>
					<td class="text-center">Usuario</td>
					<td class="text-center">Rutas subidas</td>
					<td class="text-center">Rutas recorridas</td>
					<td class="text-center">Habilitar/Deshabilitar</td>
				</tr>
			</thead>
			<tbody>
				<% HashMap<String,Usuario> usuarios = (HashMap<String,Usuario>)application.getAttribute("usuarios"); %>
				<% for(String key : usuarios.keySet()) { %>
					<tr>
						<td class="text-center"><%= key %></td>
						<td class="text-center">1</td>
						<td class="text-center">1</td>
						<td class="text-center"><button class="btn btn-xs btn-warning">Deshabilitar</button></td>
					</tr>
				<% } %>
					<tr>
						<td class="text-center">user5</td>
						<td class="text-center">1</td>
						<td class="text-center">2</td>
						<td class="text-center"><button class="btn btn-xs btn-default">Habilitar</button></td>
					</tr>
			</tbody>
		</table>
	</div>
</body>
</html>