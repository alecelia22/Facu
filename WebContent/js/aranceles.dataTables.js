$(document).ready(function() {
	// Customizacion de la pantalla
	 var table = $("#arancelesDataTable").DataTable({
	        "language": {
	            "lengthMenu": "Mostrar _MENU_ por página",
	            "sInfo" : "Pagina _PAGE_ de _PAGES_ (_TOTAL_ registros)"
	        },
	        
	        "order": [[ 1, "asc" ]],
	        
	        "columnDefs": [ 
	        {
	            "targets": -1,
	            "data": null,
	            "defaultContent": "<button class='editar'><img src='imagenes/editar.png' style='width: 16px;'/></button>"
	        },
	        {
	        	 "targets": [0],
                 "visible": false,
                 "searchable": false
	        }]
	    });

	 // Boton del EDITAR
	 $("#arancelesDataTable tbody").on( "click", "button", function () {
	        var data = table.row( $(this).parents("tr") ).data();
	        popUpUpdate(data[0], data[1], data[2], data[3], data[4], data[5]);
     });

	 // Boton de Agregar
	 $("#agregarBoton").click(popUpSave);

	 // Saco la imagen de cargando y muestro la pantalla principal
	 $("#cargando").remove();
	 $("#principal").css({"display": "block"});
});

/**
 * Creo el popUp para crear o actualizar un arancel.
 */
function popUpSave() {
	bloquearFondo();

	// Nueva pantalla de alta/modificacion de arancel
	$("#box").load("Facu/crearActualizarArancel.action");
}

/**
 * Creo el popUp para actualizar un empleador.
 */
function popUpUpdate(id, codigo, descripcion, precioSocio, precioNoSocio) {
	bloquearFondo();

	// Nueva pantalla, pero con datos cargados
	$("#box").load("Facu/crearActualizarArancel.action", function() {
		$("#id").val(id);
		$("#codigo").val(codigo);
		$("#descripcion").val(descripcion);
		$("#precioSocio").val(precioSocio);
		$("#precioNoSocio").val(precioNoSocio);		
	});
}

function bloquearFondo() {
	// Manda el scroll al principio 
	$("html, body").animate({
        scrollTop: 0
    }, 2000);
    
	// Pongo en gris la pantalla de fondo
	$("#screen").css({
		"display" : "block", 
		opacity : 0.7, 
		"width" : $(document).width(),
		"height":$(document).height()
	});

	// Creo el nuevo marco
	$("#box").css({"display": "block"});
}
