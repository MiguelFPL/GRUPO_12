<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetLogin.css"></jsp:include>
</style>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<section>
		<div class="login">
			<form action="ServletLogin" method="post">
				<h2>Iniciar sesión</h2>
				<p>Usuario</p>
				<input type="text" name="txtUsuario" required>
				<p>Contraseña</p>
				<input type="password" name="passContrasena" required> <input
					type="submit" value="Ingresar">

				<%
				String error = (String) request.getAttribute("error");
				if (error != null) {
				%>
				<p class="error"><%=error%></p>
				<%
				}
				%>
			</form>
		</div>
	</section>
</body>
</html>