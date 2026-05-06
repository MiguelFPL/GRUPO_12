<%@ page import="java.util.ArrayList"%>
<%@ page import="dominio.TipoSeguros"%>
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
	<a href="servletSeguro">Agregar Seguro</a>
	<br>
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	<br>
	Agregar Seguros
	<br>
	IdSeguro
	<br>
	Descripción <input type="Text" name="txtDescripcion">
	<br>
	 <form action="servletSeguro" method="post">
	    
	Tipo de seguro 
		<select name="cmbTipo">
			<%
	ArrayList<TipoSeguros> tipos = (ArrayList<TipoSeguros>) request.getAttribute("tipos");

	if (tipos != null) {
		for (TipoSeguros t : tipos) {
	%>
			<option value="<%= t.getIdTipo() %>"><%= t.getDescripcion() %></option>
	<%
		}
	} else {
	%>
			<option value="0">No hay tipos cargados</option>
	<%
	}
	%>	
		</select>
	     </form>
	<br>
	Costo contratación <input type="Text" name="txtCostoContratacion">
	<br>
	Costo maximo asegurado <input type="Text" name="txtCostoMaximo">
	<br>
	<form action="servletSeguro" method = "get">
	<input type = "submit" name = "btnAceptar" value = "Aceptar">
	</form>

	<%
    int filas=0;

    if (request.getAttribute("cantFilas")!=null){
        filas = (int)(request.getAttribute("cantFilas"));
    }
    %>

    <%
    if (filas == 1) {
    %>
    Seguro agregado con exito
    <%
    }
    %>

</body>
</html>
