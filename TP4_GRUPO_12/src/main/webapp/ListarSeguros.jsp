<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="Inicio.jsp">Inicio</a>
	<br>
	<a href="AgregarSeguros.jsp">Agregar Seguros</a>
	<br>
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	<br> Listado de seguros Filtrar por tipo:

	<input type="submit" name="Filtrar" value="Filtrar">
	<input type="submit" name="Mostrar" value="Mostrar todos">

	<table border = "1">
		<tr>
			<th>ID seguro</th>
			<th>Descripcion</th>
			<th>Tipo de seguro</th>
			<th>Costo de contratacion</th>
			<th>Costo max. asegurado</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>

</body>
</html>