<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguros"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Seguro</title>
</head>
<body>

	<a href="Inicio.jsp">Inicio</a>
	<a href="servletSeguro?accion=agregar">Agregar Seguros</a>
	<a href="servletSeguro?accion=listar">Listar Seguros</a>

	<h2>Agregar Seguros</h2>

	<form action="servletSeguro" method="get">
		<input type="hidden" name="accion" value="agregar">
		Id Seguro: <%= request.getAttribute("proximoId") %><br>
		Descripción: <input type="Text" name="txtDescripcion"><br>
		Tipo de seguro:
		<select name="cmbTipo">
			<%
			ArrayList<TipoSeguros> tipos = (ArrayList<TipoSeguros>) request.getAttribute("tipos");
			if (tipos != null) {
				for (TipoSeguros t : tipos) {
			%>
				<option value="<%= t.getIdTipo() %>"><%= t.getDescripcion() %></option>
			<%
				}
			}
			%>
		</select><br>
		Costo contratación: <input type="Text" name="txtCostoContratacion"><br>
		Costo Máximo Asegurado: <input type="Text" name="txtCostoMaximo"><br>
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>

	<%
	String mensaje = (String) request.getAttribute("mensaje");
	String error = (String) request.getAttribute("error");
	if (mensaje != null) {
	%>
		<p><%= mensaje %></p>
	<%
	}
	if (error != null) {
	%>
		<p><%= error %></p>
	<%
	}
	%>

</body>
</html>
