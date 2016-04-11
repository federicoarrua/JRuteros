<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros-Estadisticas</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-heading">Estadisticas de la aplicación</div>
			<div class="panel-body">
				<p>Total de usuarios registrados: 100</p>
				<p>Total de rutas subidas: 500</p>
				<p>Porcentaje de usuarios que subieron rutas: 35%</p>
				<p>Porcentaje de usuarios activos el ultimo mes: 69%</p>
			</div>
		</div>
	</div>
</body>
</html>