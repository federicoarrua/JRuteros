<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<% Ruta r = (Ruta) request.getAttribute("ruta"); %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-<%= r.getNombre() %></title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="clasesJruteros.Ruta" %>
	<%@ page import="java.text.SimpleDateFormat" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<div class="panel panel-default">
			<% SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); %>
			
			<div class="panel-heading">IMAGENES DE LA RUTA <%=r.getNombre() %> </div>
			<div class="panel-body">
				<% if(u.getUsername() != r.getDueno().getUsername()){ %>
					<a href="#">Marcar ruta como hecha</a>
				<% } %>
				<p>Descripción: <%= r.getDescripcion() %></p>
				<div class="col-sm-6">
					<p>Actividad: <%= r.getActividad() %></p>
					<p>Dificultad: <%= r.getDificultad() %></p>
					<p>Formato: <%= r.getFormato().toString() %></p>
					<p>Tiempo estimado de realizacion: <%= r.getTiempoEstimado().toString() %></p>
				</div>
					<p>Fecha de realización: <%= format.format(r.getFecha()) %></p>
					<p>Usuario que subió la ruta: <%= r.getDueno().getUsername() %></p>
					<p>Puntaje promedio: 3.5</p>
					<p>Usuarios que hicieron esta ruta: 10</p>
				<div class="col-sm-6">
				<% if(u.getUsername() != r.getDueno().getUsername()){ %>
					<form class="form-inline" action="#">
						<div class="form-group input-group">
							<select class="form-control" required>
								<option value="">--Valorar--</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
							<span class="input-group-btn" style="width:4px;"></span>
						</div>
						<button type="submit" class="btn btn-default">Valorar</button>
					</form>
				<% } %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>