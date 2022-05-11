const tablaTrazabilidad = $('#idTablaTrazabilidad');

$(document).ready(function() {

	$(".sectiontrazabilidad").hide();
	$("#listarTrazabilidad").click(function() {
		$(".sectiontrazabilidad").show();
		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/trazabilidad",
			contentType: 'application/json'
		})
			.done(function(dataTrazabilidad, textStatus, jqXHR) {
				console.log(dataTrazabilidad);
				tablaTrazabilidad.bootstrapTable({
					data: dataTrazabilidad.body,
					pagination: true,
					search: true,
					pageSize: 5,
					pageList: [5, 10],
					locale: "es-ES",
					columns: [{
						field: 'idTrazabilidad',
						title: 'ID',
						width: '40px'
					}, {
						field: 'fechaInicioPreparacion',
						title: 'Fecha Inicio',
						width: '180px'
					}, {
						field: 'fechaFinPreparacion',
						title: 'Fecha Fin',
						width: '180px'
					}, {
						field: 'fechaEstimadaEnvio',
						title: 'Fecha Estimada',
						width: '180px'
					}, {
						field: 'fechaEnvio',
						title: 'Fecha Envio',
						width: '180px'
					},
					{
						field: 'codigoTrazabilidad',
						title: 'Codigo',
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
								"<a class='like' data-bs-toggle='modal' data-bs-target='#modalEditarTrazabilidad' onclick='onClickEditarTrazabilidad(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' data-bs-toggle='modal' data-bs-target='#modalEliminarTrazabilidad' onclick='onClickEliminarTrazabilidad(\"" + row.idTrazabilidad + "\");' title='Eliminar'>",
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
	$("#idBtnAgregarTrazabilidad").click(function() {

		const validaFormNuevaTrazabilidad = () => {

			var idTxtAgregarFechaInicioPreparacion = false;
			var idTxtAgregarFechaFinPreparacion = false;
			var idTxtAgregarFechaEstimadaEnvio = false;
			var idTxtAgregarFechaEnvio = false;
			var idTxtAgregarCodigoTrazabilidad = false;

			if ($("#idTxtAgregarFechaInicioPreparacion").val() == null) {
				$("#idTxtAgregarFechaInicioPreparacion").addClass("is-invalid");
				$("#idTxtAgregarFechaInicioPreparacion").removeClass("is-valid");
				idTxtAgregarFechaInicioPreparacion = false;
			} else if ($("#idTxtAgregarFechaInicioPreparacion").val() <= 0) {
				$("#idTxtAgregarFechaInicioPreparacion").addClass("is-invalid");
				$("#idTxtAgregarFechaInicioPreparacion").removeClass("is-valid");
				idTxtAgregarFechaInicioPreparacion = false;
			} else {
				$("#idTxtAgregarFechaInicioPreparacion").removeClass("is-invalid");
				$("#idTxtAgregarFechaInicioPreparacion").addClass("is-valid");
				idTxtAgregarFechaInicioPreparacion = true;
			}
			if ($("#idTxtAgregarFechaFinPreparacion").val() == null) {
				$("#idTxtAgregarFechaFinPreparacion").addClass("is-invalid");
				$("#idTxtAgregarFechaFinPreparacion").removeClass("is-valid");
				idTxtAgregarFechaFinPreparacion = false;
			} else if ($("#idTxtAgregarFechaFinPreparacion").val() <= 0) {
				$("#idTxtAgregarFechaFinPreparacion").addClass("is-invalid");
				$("#idTxtAgregarFechaFinPreparacion").removeClass("is-valid");
				idTxtAgregarFechaFinPreparacion = false;
			} else {
				$("#idTxtAgregarFechaFinPreparacion").removeClass("is-invalid");
				$("#idTxtAgregarFechaFinPreparacion").addClass("is-valid");
				idTxtAgregarFechaFinPreparacion = true;
			}
			if ($("#idTxtAgregarFechaEstimadaEnvio").val() == null) {
				$("#idTxtAgregarFechaEstimadaEnvio").addClass("is-invalid");
				$("#idTxtAgregarFechaEstimadaEnvio").removeClass("is-valid");
				idTxtAgregarFechaEstimadaEnvio = false;
			} if ($("#idTxtAgregarFechaEstimadaEnvio").val() <= 0) {
				$("#idTxtAgregarFechaEstimadaEnvio").addClass("is-invalid");
				$("#idTxtAgregarFechaEstimadaEnvio").removeClass("is-valid");
				idTxtAgregarFechaEstimadaEnvio = false;
			} else {
				$("#idTxtAgregarFechaEstimadaEnvio").removeClass("is-invalid");
				$("#idTxtAgregarFechaEstimadaEnvio").addClass("is-valid");
				idTxtAgregarFechaEstimadaEnvio = true;
			}
			if ($("#idTxtAgregarFechaEnvio").val() == null) {
				$("#idTxtAgregarFechaEnvio").addClass("is-invalid");
				$("#idTxtAgregarFechaEnvio").removeClass("is-valid");
				idTxtAgregarFechaEnvio = false;
			} else if ($("#idTxtAgregarFechaEnvio").val() <= 0) {
				$("#idTxtAgregarFechaEnvio").addClass("is-invalid");
				$("#idTxtAgregarFechaEnvio").removeClass("is-valid");
				idTxtAgregarFechaEnvio = false;
			} else {
				$("#idTxtAgregarFechaEnvio").removeClass("is-invalid");
				$("#idTxtAgregarFechaEnvio").addClass("is-valid");
				idTxtAgregarFechaEnvio = true;
			}
			if ($("#idTxtAgregarCodigoTrazabilidad").val() == null) {
				$("#idTxtAgregarCodigoTrazabilidad").addClass("is-invalid");
				$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-valid");
				idTxtAgregarCodigoTrazabilidad = false;
			} if ($("#idTxtAgregarCodigoTrazabilidad").val() <= 0) {
				$("#idTxtAgregarCodigoTrazabilidad").addClass("is-invalid");
				$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-valid");
				idTxtAgregarCodigoTrazabilidad = false;
			} else {
				$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-invalid");
				$("#idTxtAgregarCodigoTrazabilidad").addClass("is-valid");
				idTxtAgregarCodigoTrazabilidad = true;
			}


			return idTxtAgregarFechaInicioPreparacion && idTxtAgregarFechaInicioPreparacion && idTxtAgregarFechaFinPreparacion && idTxtAgregarFechaEstimadaEnvio && idTxtAgregarFechaEnvio && idTxtAgregarCodigoTrazabilidad;
		}

		console.log(dataTrazabilidad);

		if (validaFormNuevaTrazabilidad()) {
			console.log("Todo bien");

			let dataTrazabilidad = {
				"fechaInicioPreparacion": $("#idTxtAgregarFechaInicioPreparacion").val(),
				"fechaFinPreparacion": $("#idTxtAgregarFechaFinPreparacion").val(),
				"fechaEstimadaEnvio": $("#idTxtAgregarFechaEstimadaEnvio").val(),
				"fechaEnvio": $("#idTxtAgregarFechaEnvio").val(),
				"codigoTrazabilidad": $("#idTxtAgregarCodigoTrazabilidad").val(),
			}

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataTrazabilidad),
				//Cambiar a type: POST si necesario
				type: "POST",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/trazabilidad",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
					swal({
						text: data.messageList[0].message,
						icon: "success"
					});

					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					tablaTrazabilidad.bootstrapTable('load', data.body);
					tablaTrazabilidad.bootstrapTable('refresh');
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				})

		} else {
			console.log("Nada");
		}

	});

	$('#modalNuevaTrazabilidad').on('show.bs.modal', function() {
		$("#idTxtAgregarFechaInicioPreparacion").val("");
		$("#idTxtAgregarFechaInicioPreparacion").removeClass("is-valid");
		$("#idTxtAgregarFechaInicioPreparacion").removeClass("is-invalid");

		$("#idTxtAgregarFechaFinPreparacion").val("");
		$("#idTxtAgregarFechaFinPreparacion").removeClass("is-valid");
		$("#idTxtAgregarFechaFinPreparacion").removeClass("is-invalid");

		$("#idTxtAgregarFechaEstimadaEnvio").val("");
		$("#idTxtAgregarFechaEstimadaEnvio").removeClass("is-valid");
		$("#idTxtAgregarFechaEstimadaEnvio").removeClass("is-invalid");

		$("#idTxtAgregarFechaEnvio").val("");
		$("#idTxtAgregarFechaEnvio").removeClass("is-valid");
		$("#idTxtAgregarFechaEnvio").removeClass("is-invalid");

		$("#idTxtAgregarCodigoTrazabilidad").val("");
		$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-valid");
		$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-invalid");


	});

});

let dataTrazabilidad;

//Edit Material
function onClickEditarTrazabilidad(row) {
	dataTrazabilidad = JSON.parse(row);
	console.log(dataTrazabilidad);

	//Limpiar campos del modal
	$("#idTxtEditarFechaInicioPreparacion").val(dataTrazabilidad.fechaInicioPreparacion);
	$("#idTxtEditarFechaInicioPreparacion").removeClass("is-valid");
	$("#idTxtEditarFechaInicioPreparacion").removeClass("is-invalid");

	$("#idTxtEditarFechaFinPreparacion").val(dataTrazabilidad.fechaFinPreparacion);
	$("#idTxtEditarFechaFinPreparacion").removeClass("is-valid");
	$("#idTxtEditarFechaFinPreparacion").removeClass("is-invalid");

	$("#idTxtEditarFechaEstimadaEnvio").val(dataTrazabilidad.fechaEstimadaEnvio);
	$("#idTxtEditarFechaEstimadaEnvio").removeClass("is-valid");
	$("#idTxtEditarFechaEstimadaEnvio").removeClass("is-invalid");

	$("#idTxtEditarFechaEnvio").val(dataTrazabilidad.fechaEnvio);
	$("#idTxtEditarFechaEnvio").removeClass("is-valid");
	$("#idTxtEditarFechaEnvio").removeClass("is-invalid");

	$("#idTxtEditarCodigoTrazabilidad").val(dataTrazabilidad.codigoTrazabilidad);
	$("#idTxtEditarCodigoTrazabilidad").removeClass("is-valid");
	$("#idTxtEditarCodigoTrazabilidad").removeClass("is-invalid");


	$('#modalEditarTrazabilidad').modal('show');

}

$("#idBtnEditarTrazabilidad").click(function() {

	const validaFormEditarTrazabilidad = () => {

		var idTxtEditarFechaInicioPreparacion = false;
		var idTxtEditarFechaFinPreparacion = false;
		var idTxtEditarFechaEstimadaEnvio = false;
		var idTxtEditarFechaEnvio = false;
		var idTxtEditarCodigoTrazabilidad = false;

		if ($("#idTxtEditarFechaInicioPreparacion").val() == null) {
			$("#idTxtEditarFechaInicioPreparacion").addClass("is-invalid");
			$("#idTxtEditarFechaInicioPreparacion").removeClass("is-valid");
			idTxtEditarFechaInicioPreparacion = false;
		} if ($("#idTxtEditarFechaInicioPreparacion").val() <= 0) {
			$("#idTxtEditarFechaInicioPreparacion").addClass("is-invalid");
			$("#idTxtEditarFechaInicioPreparacion").removeClass("is-valid");
			idTxtEditarFechaInicioPreparacion = false;
		} else {
			$("#idTxtEditarFechaInicioPreparacion").removeClass("is-invalid");
			$("#idTxtEditarFechaInicioPreparacion").addClass("is-valid");
			idTxtEditarFechaInicioPreparacion = true;
		}

		if ($("#idTxtEditarFechaFinPreparacion").val() == null) {
			$("#idTxtEditarFechaFinPreparacion").addClass("is-invalid");
			$("#idTxtEditarFechaFinPreparacion").removeClass("is-valid");
			idTxtEditarFechaFinPreparacion = false;
		} if ($("#idTxtEditarFechaFinPreparacion").val() <= 0) {
			$("#idTxtEditarFechaFinPreparacion").addClass("is-invalid");
			$("#idTxtEditarFechaFinPreparacion").removeClass("is-valid");
			idTxtEditarFechaFinPreparacion = false;
		} else {
			$("#idTxtEditarFechaFinPreparacion").removeClass("is-invalid");
			$("#idTxtEditarFechaFinPreparacion").addClass("is-valid");
			idTxtEditarFechaFinPreparacion = true;
		}
		if ($("#idTxtEditarFechaEstimadaEnvio").val() == null) {
			$("#idTxtEditarFechaEstimadaEnvio").addClass("is-invalid");
			$("#idTxtEditarFechaEstimadaEnvio").removeClass("is-valid");
			idTxtEditarFechaEstimadaEnvio = false;
		} if ($("#idTxtEditarFechaEstimadaEnvio").val() <= 0) {
			$("#idTxtEditarFechaEstimadaEnvio").addClass("is-invalid");
			$("#idTxtEditarFechaEstimadaEnvio").removeClass("is-valid");
			idTxtEditarFechaEstimadaEnvio = false;
		} else {
			$("#idTxtEditarFechaEstimadaEnvio").removeClass("is-invalid");
			$("#idTxtEditarFechaEstimadaEnvio").addClass("is-valid");
			idTxtEditarFechaEstimadaEnvio = true;
		}
		if ($("#idTxtEditarFechaEnvio").val() == null) {
			$("#idTxtEditarFechaEnvio").addClass("is-invalid");
			$("#idTxtEditarFechaEnvio").removeClass("is-valid");
			idTxtEditarFechaEnvio = false;
		} if ($("#idTxtEditarFechaEnvio").val() <= 0) {
			$("#idTxtEditarFechaEnvio").addClass("is-invalid");
			$("#idTxtEditarFechaEnvio").removeClass("is-valid");
			idTxtEditarFechaEnvio = false;
		} else {
			$("#idTxtEditarFechaEnvio").removeClass("is-invalid");
			$("#idTxtEditarFechaEnvio").addClass("is-valid");
			idTxtEditarFechaEnvio = true;
		}
		if ($("#idTxtEditarCodigoTrazabilidad").val() == null) {
			$("#idTxtEditarCodigoTrazabilidad").addClass("is-invalid");
			$("#idTxtEditarCodigoTrazabilidad").removeClass("is-valid");
			idTxtEditarCodigoTrazabilidad = false;
		} if ($("#idTxtEditarCodigoTrazabilidad").val() <= 0) {
			$("#idTxtEditarCodigoTrazabilidad").addClass("is-invalid");
			$("#idTxtEditarCodigoTrazabilidad").removeClass("is-valid");
			idTxtEditarCodigoTrazabilidad = false;
		} else {
			$("#idTxtEditarCodigoTrazabilidad").removeClass("is-invalid");
			$("#idTxtEditarCodigoTrazabilidad").addClass("is-valid");
			idTxtEditarCodigoTrazabilidad = true;
		}

		return idTxtEditarFechaInicioPreparacion && idTxtEditarFechaFinPreparacion && idTxtEditarFechaEstimadaEnvio && idTxtEditarFechaEnvio && idTxtEditarCodigoTrazabilidad;
	}

	if (validaFormEditarTrazabilidad()) {
		console.log("todo bien");

		let dataTrazabilidadId = dataTrazabilidad.idTrazabilidad;

		dataTrazabilidad = {
			"fechaInicioPreparacion": $("#idTxtEditarFechaInicioPreparacion").val(),
			"fechaFinPreparacion": $("#idTxtEditarFechaFinPreparacion").val(),
			"fechaEstimadaEnvio": $("#idTxtEditarFechaEstimadaEnvio").val(),
			"fechaEnvio": $("#idTxtEditarFechaEnvio").val(),
			"codigoTrazabilidad": $("#idTxtEditarCodigoTrazabilidad").val(),
		}

		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataTrazabilidad),
			//Cambiar a type: POST si necesario
			type: "PUT",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: `/trazabilidad/${dataTrazabilidadId}`,
			contentType: 'application/json;charset=UTF-8'
		})
			.done(function(data, textStatus, jqXHR) {
				swal({
					text: data.messageList[0].message,
					icon: "success"
				});
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Productos a refrescar", data.body);
				tablaTrazabilidad.bootstrapTable('load', data.body);
				tablaTrazabilidad.bootstrapTable('refresh');

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
function onClickEliminarTrazabilidad(id) {
	console.log("Id a eliminar: " + id);
	$('#modalEliminarTrazabilidad').modal('show');
	dataTrazabilidad = {
		"idTrazabilidad": id
	};
}

$("#idBtnEliminarTrazabilidad").click(function() {

	console.log('id to delete: ' + dataTrazabilidad.idTrazabilidad);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataTrazabilidad),
		//Cambiar a type: POST si necesario
		type: "DELETE",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/trazabilidad",
		contentType: 'application/json;charset=UTF-8'
	})
		.done(function(data, textStatus, jqXHR) {
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			$('#modalEliminarTrazabilidad').modal('hide');
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Productos a refrescar", data.body);
			tablaTrazabilidad.bootstrapTable('load', data.body);
			tablaTrazabilidad.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			swal({
				text: "error",
				icon: "error"
			});
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});