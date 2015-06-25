<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>FACU - Aranceles</title>
	<!-- SCRIPTS -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/aranceles.dataTables.js"></script>
	<!-- CSSs-->
	<link rel="StyleSheet" href="css/dataTables/jquery.dataTables.css" type="text/css">
	<link rel="StyleSheet" href="css/listarAranceles.css" type="text/css">
	<link rel="StyleSheet" href="css/facu.css" type="text/css">
</head>
<body class="facu">
	<!-- Cargando -->
    <div id="cargando" style="opacity : 0.8; width : 100%; height:100%;">
    	<div>
    		<img src="imagenes/loading.gif" style="top: 30%; left: 40%; position: fixed;"/>
    	</div>
    </div>

	<div style="width: 100%;" align="center">
		<h1 id="titulo">Aranceles</h1>
	</div>

	<!-- Principal -->
	<div id="principal" style="display:none;">
		<table id="arancelesDataTable" class="display" cellspacing="0" width="100%">
	       	<thead>
	       		<tr>
	       			<th>id</th>
	       			<th>Codigo</th>
	       			<th>Concepto</th>
	       			<th>Precio Socio</th>
	       			<th>Precio No Socio.</th>
	       			<th>Editar</th>
	       		</tr>
	       	</thead>
		    <tbody>
				<s:iterator value="arancelesDTO" var="arancelesList">
					<tr>
			            <td><s:property value="id"/></td>
			            <td><s:property value="codigo"/></td>
			            <td><s:property value="descripcion"/></td>
			            <td align="center"><s:property value="precioSocio"/></td>
			            <td align="center"><s:property value="precioNoSocio"/></td>
			            <td></td>
			        </tr>
		    	</s:iterator>
		   	</tbody>
		</table>

    	<input type="button" value="Agregar Arancel" id="agregarBoton"/>
	</div>

	<!-- PopUp -->
    <div id="box"></div>
    <div id="screen"></div>

</body>
</html>
