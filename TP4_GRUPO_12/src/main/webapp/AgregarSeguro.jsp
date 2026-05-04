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
	<br>
	Agregar Seguros
	<br>
	IdSeguro
	<br>
	<form action="servletSeguro" method = "get">
	Descripción <input type="Text" name="txtDescripcion">
	<br>
	Tipo de seguro
	<br>
	Costo contratación <input type="Text" name="txtCostoContratacion">
	<br>
	Costo maximo asegurado <input type="Text" name="txtCostoMaximo">
	<br>
	<input type = "submit" name = "bntAceptar" value = "Aceptar">
	</form>

</body>
</html>