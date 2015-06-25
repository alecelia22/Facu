$(document).ready(function () {
	// Pongo el foco en el codigo
	$("#codigo").focus();

	// Cargo la funcion del boton de guardar
	$("#guardarArancel").click(guardarArancel);
	
	// Solo pueden ingresar numero y una coma
	$("#precioSocio").keyup(numeroConDecimales);
	$("#precioNoSocio").keyup(numeroConDecimales);

	// Cerrar Ventana
	$("#cerrar").click(cerrarVentana);
});

/**
 * Ejecuto el save o update del arancel.
 */
function guardarArancel() {
	// Escondo si quedo algun msj anterior
	$("#mensajes").hide();
	// Tomo los valores de pantalla
	var codigo = $("#codigo");
	var descripcion = $("#descripcion");

	// Valido los valores
	if (ingresoDato(codigo, "Codigo") && ingresoDato(descripcion, "Descripcion")) {

		// ejecuto el alta de la modificacion
		$.ajax({
		       type: "POST",
		       url:"Facu/guardarArancel.action",
		       data : { "id" : $("#id").val(),
		    	   "codigo" : $("#codigo").val(),
		    	   "descripcion" :  $("#descripcion").val(),
		    	   "precioSocio" :  $("#precioSocio").val(),
		    	   "precioNoSocio" : $("#precioNoSocio").val()},
	           dataType : "json",
		       error: errorAjax,
		       success: arancelGuardado
		});
	}
}

/**
 * Valido q ingreso el valor, sino muestro msj 
 */
function ingresoDato(campo, label) {
	if (campo.val() == null || campo.val() == "") {
		$("#mensajes").text("Falta completar el campo: " + label);
		$("#mensajes").show("slow");
		campo.focus();
		return false;
	} else {
		return true;
	}
}

/**
 * Mensaje de q se guardo el msj.
 */
function arancelGuardado() {
	// Mensaje de se guardo o actualizo bien 
	if ($("#id").val() != null && $("#id").val() != "") {
		alert("Se actualizo el Arancel");
	} else {
		alert("Se creo el Arancel");	
	}
	// cierro el popUp
	cerrarVentana();
	// Recargo la pantalla
	window.location.reload();
}

/**
 * Remplazo todo por numeros y una coma
 * Si tengo 2 comas, elimino lo q sobra.
 */
function numeroConDecimales() {
	// Elimino todo menos lo numeros y las comas
	this.value = this.value.replace(/[^0-9\,]/g,'');

	// Separo por comas
	var comas = this.value.split(",");
	// Si hay mas de 2 bloques, entonces son 2 comas
	if (comas.length > 2) {
		// Dejo todo lo q esta a la izquierda de la segunda coma
		this.value = comas[0] + "," + comas[1];
	}	
}

/**
 * Analizo las teclas q toca el usuario.
 * Si es Esc salgo del popUp
 */
$(document).keyup(function(e) {
	// Presiono Escape
	if (e.keyCode == 27) {
		cerrarVentana();
	}
});

/**
 * Cierro la ventana 
 */
function cerrarVentana() {
	// Blanqueo el box por las dudas
	$("#box").empty();
	// Ciero la ventana
	$("#box").css("display", "none");
	// Desactivo el covertor del fondo
	$("#screen").css("display", "none");
}

/**
 * Mensaje, en caso de error con la llamada a ajax
 */
function errorAjax() {
	alert("Problema en el servidor");
}