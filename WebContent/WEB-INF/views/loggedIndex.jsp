<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JRuteros</title>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<h1>Bienvenido a JRuteros!</h1>
		
		<table class="table">
			<thead><tr><td><h4>Ultimas actualizaciones</h4></td></tr></thead>
			<tbody>	
				<tr><td>14:03 -- El usuario user1 recorrió la ruta ruta1</td></tr>
				<tr><td>10:20 -- El usuario admin subió la ruta ruta1</td></tr>
				<tr><td>09:45 -- El usuario user3 recorrió la ruta ruta3</td></tr>
			</tbody>
		</table>
	</div>
</body>
</html>