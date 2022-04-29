$(document).ready(function() {

	$("#listarMateriales").click(function() {
		
		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/materiales",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				//				swal({
				//					text: data.messageList[0].message,
				//					icon: "success"
				//				});

				tableMateriales.bootstrapTable({
					data: data.body,
					pagination: true,
					search: true,
					pageSize: 5,
					pageList: [5, 10],
					locale: "es-ES",
					columns: [{
						field: 'idBodega',
						title: 'ID',
						width: '40px'
					}, {
						field: 'nombre_bodega',
						title: 'Nombre',
						width: '180px'
					},
					{
						field: 'fecha_ingreso',
						title: 'Fecha Ingreso',
						width: '180px'
					},
					{
						field: '',
						title: 'Accion',
						align: 'center',
						valign: 'middle',
						width: '150px',
						clickToSelect: false,
						formatter: function(value, row, index) {
							//Aqui defines el boton y en tu caso tendras que ponerle el onClick, 
							//recuerda que row tiene el objeto del renglon actual, 
							//en este ejemplo agrege funcionPorDefinir y le envio el row.id
							//console.log(JSON.stringify(row));
							//console.log($.param(row))
							return [
								"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarMaterial' onclick='onClickEditarMaterial(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarMaterial' onclick='onClickEliminarMaterial(\"" + row.idBodega + "\");' title='Eliminar'>",
								'<i class="fa fa-trash"></i>',
								'</a>'
							].join('');
						}
					}
					]
				});

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});

	});

	$("#idBtnGuardarMateriales").click(function() {

		const validaFormNuevaBodega = () => {

			var idTxtAgregarNombreBodega = false;
			var idTxtAgregarFecha = false;
			//var idTxtAgregarAutor = false;
			//var idTxtAgregarImprenta = false;

			if ($("#idTxtAgregarNombreBodega").val().length == 0) {
				$("#idTxtAgregarNombreBodega").addClass("is-invalid");
				$("#idTxtAgregarNombreBodega").removeClass("is-valid");
				idTxtAgregarNombreBodega = false;
			} else {
				$("#idTxtAgregarNombreBodega").removeClass("is-invalid");
				$("#idTxtAgregarNombreBodega").addClass("is-valid");
				idTxtAgregarNombreBodega = true;
			}

			if ($("#idTxtAgregarFecha").val().length == 0) {
				$("#idTxtAgregarFecha").addClass("is-invalid");
				$("#idTxtAgregarFecha").removeClass("is-valid");
				idTxtAgregarFecha = false;
			} else {
				$("#idTxtAgregarFecha").removeClass("is-invalid");
				$("#idTxtAgregarFecha").addClass("is-valid");
				idTxtAgregarFecha = true;
			}
			/*
				if ($("#idTxtAgregarAutor").val().length == 0) {
					$("#idTxtAgregarAutor").addClass("is-invalid");
					$("#idTxtAgregarAutor").removeClass("is-valid");
					idTxtAgregarAutor = false;
				} else {
					$("#idTxtAgregarAutor").removeClass("is-invalid");
					$("#idTxtAgregarAutor").addClass("is-valid");
					idTxtAgregarAutor = true;
				}
	
				if ($("#idTxtAgregarImprenta").val().length == 0) {
					$("#idTxtAgregarImprenta").addClass("is-invalid");
					$("#idTxtAgregarImprenta").removeClass("is-valid");
					idTxtAgregarImprenta = false;
				} else {
					$("#idTxtAgregarImprenta").removeClass("is-invalid");
					$("#idTxtAgregarImprenta").addClass("is-valid");
					idTxtAgregarImprenta = true;
				}
		*/
			return idTxtAgregarNombreBodega & idTxtAgregarFecha;
		}

		let dataMateriales = {
			"nombre_bodega": $("#idTxtAgregarNombreBodega").val(),
			"fecha_ingreso": $("#idTxtAgregarFecha").val(),
			//"autor": $("#idTxtAgregarAutor").val(),
			//"imprenta": $("#idTxtAgregarImprenta").val(),
			//"disponibilidad": $("#idTxtAgregarDisponible").val(),
		}

		//if ($('#idTxtAgregarNoDisponible').is(':checked')) {
		//console.log("Entré");
		//dataLibro.disponibilidad = $("#idTxtAgregarNoDisponible").val();
		//}

		console.log(dataMateriales);

		if (validaFormNuevaBodega()) {
			console.log("Todo bien");

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataMateriales),
				//Cambiar a type: POST si necesario
				type: "POST",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/materiales",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
					swal({
						text: data.messageList[0].message,
						icon: "success"
					});
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					tableMateriales.bootstrapTable('load', data.body);
					tableMateriales.bootstrapTable('refresh');

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});

		} else {
			console.log("Nada");
		}

	});

	$('#modalNuevoMaterial').on('show.bs.modal', function() {
		$("#idTxtAgregarNombreBodega").val("");
		$("#idTxtAgregarNombreBodega").removeClass("is-valid");
		$("#idTxtAgregarNombreBodega").removeClass("is-invalid");

		$("#idTxtAgregarFecha").val("");
		$("#idTxtAgregarFecha").removeClass("is-valid");
		$("#idTxtAgregarFecha").removeClass("is-invalid");
		/*
				$("#idTxtAgregarAutor").val("");
				$("#idTxtAgregarAutor").removeClass("is-valid");
				$("#idTxtAgregarAutor").removeClass("is-invalid");
		
				$("#idTxtAgregarImprenta").val("");
				$("#idTxtAgregarImprenta").removeClass("is-valid");
				$("#idTxtAgregarImprenta").removeClass("is-invalid");
			*/
	});

});

// Global variable
let dataMaterial;

//Edit Bodega
function onClickEditarMaterial(row) {
	console.log(row);
	dataMaterial = JSON.parse(row);

	//Limpiar campos del modal
	$("#idTxtEditarNombreBodega").val(dataMaterial.nombre_bodega);
	$("#idTxtEditarNombreBodega").removeClass("is-valid");
	$("#idTxtEditarNombreBodega").removeClass("is-invalid");

	$("#idTxtEditarFecha").val(dataMaterial.fecha_ingreso);
	$("#idTxtEditarFecha").removeClass("is-valid");
	$("#idTxtEditarFecha").removeClass("is-invalid");

	console.log(dataMaterial);

}

$("#idBtnEditarMaterial").click(function() {

	const validaFormEditarBodega = () => {

		var idTxtEditarNombreMaterial = false;
		var idTxtEditarFechaMaterial = false;

		if ($("#idTxtEditarNombreMaterial").val().length == 0) {
			$("#idTxtEditarNombreMaterial").addClass("is-invalid");
			$("#idTxtEditarNombreMaterial").removeClass("is-valid");
			idTxtEditarNombreMaterial = false;
		} else {
			$("#idTxtEditarNombreMaterial").removeClass("is-invalid");
			$("#idTxtEditarNombreMaterial").addClass("is-valid");
			idTxtEditarNombreMaterial = true;
		}

		if ($("#idTxtEditarFechaMaterial").val().length == 0) {
			$("#idTxtEditarFechaMaterial").addClass("is-invalid");
			$("#idTxtEditarFechaMaterial").removeClass("is-valid");

			idTxtEditarFechaMaterial = false;
		} else {
			$("#idTxtEditarFechaMaterial").removeClass("is-invalid");
			$("#idTxtEditarFechaMaterial").addClass("is-valid");
			idTxtEditarFechaMaterial = true;
		}

		return idTxtEditarNombreMaterial && idTxtEditarFechaMaterial;
	}

	dataMaterial = {
		"idBodega": dataMateriales.idMaterial,
		"nombre_material": $("#idTxtEditarNombreBodega").val(),
		"fecha_ingreso": $("#idTxtEditarFecha").val(),
	}

	if (validaFormEditarBodega()) {
		console.log(dataMaterial);
		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataMaterial),
			//Cambiar a type: POST si necesario
			type: "PUT",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/materiales",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				swal({
					text: data.messageList[0].message,
					icon: "success"
				});
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Bodegas a refrescar", data.body);
				tableMateriales.bootstrapTable('load', data.body);
				tableMateriales.bootstrapTable('refresh');

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				swal({
					text: "error",
					icon: "error"
				});
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
	}
});


//Delete Bodega
function onClickEliminarMaterial(id) {
	console.log("Id a eliminar: " + id);

	dataMaterial = {
		"idBodega": id
	};
}

$("#idBtnEliminarMaterial").click(function() {

	console.log('id to delete: ' + dataMaterial.idMaterial);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataMaterial),
		//Cambiar a type: POST si necesario
		type: "DELETE",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/materiales",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Bodegas a refrescar", data.body);
			tableMateriales.bootstrapTable('load', data.body);
			tableMateriales.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			swal({
				text: "error",
				icon: "error"
			});
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});