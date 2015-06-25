<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="StyleSheet" href="css/menu.css" type="text/css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/menu.js"></script>
		<title>Menu</title>
	</head>
	<body style="background-color: #D9D9D7;">
		<s:set name="menuRol" value="rol"/>

		<div>
			<ul id="accordion">
				<li>
			    	<div>Operación</div>
			        <ul>
			        	<li><a href="iniciarFacturacion.action" target="principal"><p>Facturacion</p></a></li>
			        </ul>
			    </li>
			    <li>
			    	<div>Configuración</div>
			        <ul>
			            <li><a href="listarAranceles.action" target="principal"><p>Aranceles</p></a></li>
			            <li><a href=".action" target="principal"><p>Clientes</p></a></li>
			        </ul>
			    </li>
			    <s:if test="%{#menuRol=='ADMIN'}">
				    <li>
				    	<div>Administración</div>
				        <ul>
							<li><a href="iniciarGeneracionRecibos.action" target="principal"><p>Generar Recibos</p></a></li>
							<li><a href="iniciarRegeneracionRecibos.action" target="principal"><p>Regenerar Recibos</p></a></li>
				        </ul>
				    </li>
			    </s:if>
			</ul>
		</div>

		<div id="salir" align="center">
			<a href="logout.action" target="_top" id="salirBoton">Salir</a>
			<br>
			<span id="usuario">Usuario: <s:property value="idUsuario"/></span>
			<span id="usuario">Rol: <s:property value="rol"/></span>
			<br>
		</div>
	</body>
</html>
