<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.Seguro"%>
<%@ page import="dominio.TipoSeguros"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Seguros</title>
</head>
<body>

	<a href="Inicio.jsp">Inicio</a>
	<a href="servletSeguro?accion=agregar">Agregar Seguros</a>
	<a href="servletSeguro?accion=listar">Listar Seguros</a>

	<h2>Listado de Seguros</h2>

	<form action="servletSeguro" method="get">
		<input type="hidden" name="accion" value="listar">
		Filtrar por tipo:
		<select name="cmbTipo">
			<option value="0">-- Todos --</option>
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
		</select>
		<input type="submit" name="btnFiltrar" value="Filtrar">
		<input type="submit" name="btnMostrar" value="Mostrar todos">
	</form>

	<table border="1">
		<tr>
			<th>ID Seguro</th>
			<th>Descripción</th>
			<th>Tipo de Seguro</th>
			<th>Costo Contratación</th>
			<th>Costo Máx. Asegurado</th>
		</tr>
		<%
		ArrayList<Seguro> seguros = (ArrayList<Seguro>) request.getAttribute("seguros");
		if (seguros != null) {
			for (Seguro s : seguros) {
		%>
		<tr>
			<td><%= s.getIdSeguro() %></td>
			<td><%= s.getDescripcion() %></td>
			<td><%= s.getTipoSeguros().getDescripcion() %></td>
			<td><%= s.getCostoContratacion() %></td>
			<td><%= s.getCostoAsegurado() %></td>
		</tr>
		<%
			}
		}
		%>
	</table>

</body>
</html>