<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Actividades</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="java.util.ArrayList" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<h1>Administrador de actividades</h1>
		<br>
		<div>
			<form action="#" class="form-inline">
				<input  type="text" class="form-control" name="actividad" placeholder="Nueva actividad...">
				<button type="submit" class="btn btn-primary">Agregar nueva actividad</button>
			</form>
		</div>
		<br>
		<h3>Lista de actividades</h3>
		<table class="table table-condensed">
			<thead>
				<tr>
					<td>Actividad</td>
					<td class="text-center">Editar</td>
					<td class="text-center">Habilitar/Deshabilitar</td>
					<td class="text-center">Dar de baja</td>
				</tr>
			</thead>
			<tbody>
				<% ArrayList<String> actividades = (ArrayList<String>)application.getAttribute("actividades"); %>
				<% for(int i=0; i<actividades.size() ; i++) { %>
					<tr>
						<td><%= actividades.get(i) %></td>
						<td class="text-center"><button class="btn btn-xs btn-default">Editar</button></td>
						<td class="text-center"><button class="btn btn-xs btn-warning">Deshabilitar</button></td>
						<td class="text-center"><button class="btn btn-xs btn-danger">Eliminar</button></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>