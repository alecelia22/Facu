<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Alta Arancel</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/arancel.js"></script>

		<link rel="StyleSheet" href="css/facu.css" type="text/css">
	</head>
	<body class="facu">
		<div>
			<input type="hidden" id="id" >
			<h1 class="titulo">ARANCEL:</h1>
		 	<span>Codigo: </span>
		 	<input type="text" id="codigo" maxlength="5" size="40px;" />
		 	<br><br>
		 	<span>Descripcion: </span>
		 	<input type="text" id="descripcion" maxlength="45" size="60px;" />
		 	<br><br>
		 	<span>Precio Socio: </span>
		 	<input type="text" id="precioSocio" maxlength="7" size="40px;" />
		 	<br><br>
			<span>Precio No Socio: </span>
		 	<input type="text" id="precioNoSocio" maxlength="7" size="40px;" />
		 	<br><br>

		 	<input type="button" id="guardarArancel" value="Guardar" />
		 	<input type="button" id="cerrar" value="Cerrar" />
		</div>

		<div id="mensajes" style="background-color: red; color: yellow;"></div>

	</body>
</html>