<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<style type="text/css">
	<jsp:include page="css\StyleSheetAltaCliente.css"></jsp:include>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contenedor">
		<nav class="barra">
			<h2>Menú</h2>
			<ul>
				<li><a href="AltaCliente.jsp"><span>Alta de Cliente</span></a></li>
				<li><a href="ListadoClientes.jsp"><span>Listado de
							Clientes</span></a></li>
			</ul>
		</nav>

		<section class="contenido">
			<h1>Formulario de Cliente</h1>
			<fieldset>
				<form action="ServletAltaCliente" method=get>
					<input type="hidden" name=accion value= "agregar">
					<div class="columnas">
						<div class="campo"></div>
						<div class="campo"></div>
						<div class="campo"></div>
						<div class="campo"></div>
						<div class="campo"></div>
						<div class="campo"></div>

						<div class="campo">
							<label>DNI</label> <input type="number" maxlength="8" name="dni"
								required> <small>Solo números 6 a 8 dígitos (ej:
								12345678).</small>
						</div>
						<div class="campo">
							<label>CUIL</label> <input type="number" maxlength="11" name="cuil"
								required> <small>Formato: 11 dígitos (ej:
								20333444555)</small>
						</div>
						<div class="campo">
							<label>Nombre</label> <input type="text" name="txtNombre"
								required>
						</div>
						<div class="campo">
							<label>Apellido</label> <input type="text" name="txtApellido"
								required>
						</div>
						<div class="campo">
							<label>Sexo</label> <select name="cmbSexo" required>
								<option value="" disabled selected>-- Seleccione --</option>
								<option value="1">Femenino</option>
								<option value="2">Masculino</option>
							</select>
						</div>
						<div class="campo">
							<label>Nacionalidad</label> <input type="text"
								name="txtNacionalidad">
						</div>
						<div class="campo">
							<label>Fecha de nacimiento</label> <input type="date"
								name="fecha" required>
						</div>
						<div class="campo">
							<label>Dirección</label> <input type="text" name="txtDireccion">
						</div>
						<div class="campo">
							<label>Localidad</label> <input type="text" name="txtLocalidad">
						</div>
						<div class="campo">
							<label>Provincia</label> <input type="text" name="txtProvincia">
						</div>
						<div class="campo">
							<label>Correo electrónico</label> <input type="email"
								name="email" required> <small>Ej:
								nombre@dominio.com</small>
						</div>
						<div class="campo">
							<label>Teléfono</label> <input type="number" maxlength="10" name="tel">
						</div>
						<div class="boton-container">
							<input type="submit" name="btnGuardar" value="Guardar cliente">
						</div>
					</div>
				</form>
			</fieldset>
		</section>
	</div>
</body>
</html>