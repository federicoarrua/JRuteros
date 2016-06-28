<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-<%= usuario.getUsername() %></title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="clasesJruteros.Usuario" %>
	<%@ page import="java.text.SimpleDateFormat" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<div class="panel panel-default">
			<% SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); %>
			<div class="panel-heading">
				<img alt="" src="images/usuario.jpg">
			</div>
			<div class="panel-body">
				<p>E-mail: <%= usuario.getEmail() %></p>
				<div class="col-sm-6">
					<p>Nombre y Apellido: <%= usuario.getNombres() %> <%= usuario.getApellido() %></p>
					<p>Fecha de nacimiento: <%= format.format(usuario.getFechaNac()) %></p>
					<p>Sexo: <%= usuario.getSexo() %></p>
				</div>
					<p>Domicilio: <%= usuario.getDomicilio() %></p>
					<p>DNI: <%= usuario.getDni() %></p>
				<div class="col-sm-6">
				</div>
			</div>
		</div>
	</div>
</body>
</html>