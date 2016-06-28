<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/WEB-INF/layouts/dependencies.html" %>
	<%@ page import="enumJruteros.*" %>
	<%@ page import="java.util.ArrayList" %>
	<title>JRuteros - Subir ruta</title>
</head>
<body background="images/background.jpg">
	<%@ include file="/WEB-INF/layouts/loggedMenus.jsp" %>
	<div class="col-md-8">
		<h2>Subir nueva ruta</h2>
		<form action="subirRuta" method="POST" data-toggle="validator" >
			<div class="form-group input-group">
				<input type="text" name="nombre" placeholder="Nombre de la ruta" class="form-control" required>
				<span class="input-group-btn" style="width:4px;"></span>
				<input type="number" min="1" name="distancia" placeholder="Distancia en KM" class="form-control" required>
			</div>
			<div class="form-group">
				<label>Descripcion</label>
				<textarea type="text" name="descripcion" placeholder="Descripción de la ruta" class=form-control rows="3"></textarea>
			</div>
			<div class="form-group input-group">
				<select class="form-control" name="actividad" required>
					<option value="">--Tipo de actividad--</option>
					<% ArrayList<String> acts = (ArrayList<String>)application.getAttribute("actividades"); %>
					<% for(int i=0;i<acts.size();i++){ %>
						<option value="<%= acts.get(i)%>"><%= acts.get(i) %></option>
					<% } %>
				</select>
				<span class="input-group-btn" style="width:4px;"></span>
				<select class="form-control" name="dificultad" required>
					<option value="">--Dificultad--</option>
					<% for(Dificultad d : Dificultad.values()){ %>
						<option value="<%= d %>"><%= d %></option>
					<% } %>
				</select>
				<span class="input-group-btn" style="width:4px;"></span>
				<select class="form-control" name="dificultad" required>
					<option value="">--Formato--</option>
					<% for(Formato f : Formato.values()){ %>
						<option value="<%= f %>"><%= f %></option>
					<% } %>
				</select>				
			</div>
			<div class="form-group input-group">
				<input class="form-control" id="date" name="date" placeholder="Fecha de realizacion" type="text"/>				
				<span class="input-group-btn" style="width:4px;"></span>
				<select class="form-control" name="tiempo" required>
					<option value="">Tiempo estimado de realización</option>
					<%for(int hr=0 ;hr<10; hr++){ %>
					<%for(int min=0;min<6;min+=3){ %>
						<option value="<%= hr %>:<%= min %>0"><%= hr %>:<%= min %>0</option>
					<% }} %>
				</select>

			</div>
			<div class="form-group input-group">
				<select class="form-control" name="privacidad" required>
					<option value="">--Privacidad--</option>
					<% for(Privacidad p : Privacidad.values()){ %>
						<option value="<%= p %>"><%= p %></option>
					<% } %>
				</select>
				<span class="input-group-btn" style="width:4px;"></span>
			    <button type="submit" class="btn btn-default">Mapa de la ruta</button>
				<span class="input-group-btn" style="width:4px;"></span>
			    <button type="submit" class="btn btn-default">Imagenes de la ruta</button>
			</div>
			<button type="submit" class="btn btn-primary">Subir</button>
		</form>
	</div>
</body>
</html>