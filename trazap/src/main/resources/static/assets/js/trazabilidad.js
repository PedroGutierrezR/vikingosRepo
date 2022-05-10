const tablaTrazabilidad = $('#idTablaTrazabilidad');
$(document).ready(function() {
	$("#sectiontrazabilidad").hide();
	$("#listarTrazabilidad").click(function() {
		$("#sectiontrazabilidad").show();
		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/trazabilidad",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				console.log(data);
				tablaTrazabilidad.bootstrapTable({
					data: data.body,
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
					}, {
						field: 'pedidos',
						title: 'Pedido',
						width: '180px'
					},
					{
						field: 'estadoTrazabilidad',
						title: 'Estado Trazabilidad',
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
								"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarTrazabilidad' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarTrazabilidad' onclick='onClickEliminar(\"" + row.idTrazabilidad + "\");' title='Eliminar'>",
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
	$("#idBtnGuardarTrazabilidad").click(function() {

		const validaFormNuevaTrazabilidad = () => {

			var idTxtAgregarFechaInicioPreparacion = false;
			var idTxtAgregarFechaFinPreparacion = false;
			var idTxtAgregarFechaEstimadaEnvio = false;
			var idTxtAgregarFechaEnvio = false;
			var idTxtAgregarCodigoTrazabilidad = false;
			var idTxtAgregarPedido = false;
			var idTxtAgregarEstadoTrazabilidad = false;

			if ($("#idTxtAgregarFechaInicioPreparacion").val().length == 0) {
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
			} else if ($("#idTxtAgregarFechaEstimadaEnvio").val() <= 0) {
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
			} else if ($("#idTxtAgregarCodigoTrazabilidad").val() <= 0) {
				$("#idTxtAgregarCodigoTrazabilidad").addClass("is-invalid");
				$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-valid");
				idTxtAgregarCodigoTrazabilidad = false;
			} else {
				$("#idTxtAgregarCodigoTrazabilidad").removeClass("is-invalid");
				$("#idTxtAgregarCodigoTrazabilidad").addClass("is-valid");
				idTxtAgregarCodigoTrazabilidad = true;
			}
			if ($("#idTxtAgregarPedido").val() == null) {
				$("#idTxtAgregarPedido").addClass("is-invalid");
				$("#idTxtAgregarPedido").removeClass("is-valid");
				idTxtAgregarPedido = false;
			} else if ($("#idTxtAgregarPedido").val() <= 0) {
				$("#idTxtAgregarPedido").addClass("is-invalid");
				$("#idTxtAgregarPedido").removeClass("is-valid");
				idTxtAgregarPedido = false;
			} else {
				$("#idTxtAgregarPedido").removeClass("is-invalid");
				$("#idTxtAgregarPedido").addClass("is-valid");
				idTxtAgregarPedido = true;
			}
			if ($("#idTxtAgregarEstadoTrazabilidad").val() == null) {
				$("#idTxtAgregarEstadoTrazabilidad").addClass("is-invalid");
				$("#idTxtAgregarEstadoTrazabilidad").removeClass("is-valid");
				idTxtAgregarEstadoTrazabilidad = false;
			} else if ($("#idTxtAgregarEstadoTrazabilidad").val() <= 0) {
				$("#idTxtAgregarEstadoTrazabilidad").addClass("is-invalid");
				$("#idTxtAgregarEstadoTrazabilidad").removeClass("is-valid");
				idTxtAgregarEstadoTrazabilidad = false;
			} else {
				$("#idTxtAgregarEstadoTrazabilidad").removeClass("is-invalid");
				$("#idTxtAgregarEstadoTrazabilidad").addClass("is-valid");
				idTxtAgregarEstadoTrazabilidad = true;
			}

			return idTxtAgregarFechaInicioPreparacion && idTxtAgregarFechaInicioPreparacion && idTxtAgregarFechaFinPreparacion && idTxtAgregarFechaEstimadaEnvio && idTxtAgregarFechaEnvio && idTxtAgregarCodigoTrazabilidad && idTxtAgregarPedido && idTxtAgregarEstadoTrazabilidad;
		}

		let dataTrazabilidad = {
			"fechaInicioPreaparacion": $("#idTxtAgregarFechaInicioPreparacion").val(),
			"fechaFinPreaparacion": $("#idTxtAgregarFinPreparacion").val(),
			"fechaEstimadaEnvio": $("#idTxtAgregarFechaEstimadaEnvio").val(),
			"fechaEnvio": $("#idTxtAgregarFechaEnvio").val(),
			"codigoTrazabilidad": $("#idTxtAgregarCodigoTrazabilidad").val(),
			"pedido": $("#idTxtAgregarPedido").val(),
			"estadoTrazabilidad": $("#idTxtAgregarEstadoTrazabilidad").val(),
		}

		console.log(dataTrazabilidad);

		if (validaFormNuevaTrazabilidad()) {
			console.log("Todo bien");

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
					tablaProductos.bootstrapTable('load', data.body);
					tablaProductos.bootstrapTable('refresh');
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				})

		} else {
			console.log("Nada");
		}

	});

});

function getTipoTrazabilidad() {

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/trazabilidad",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log("perfect");
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);

			for (i = 0; i < data.body.length; i++) {
				$(".option1").after(`<option value="${data.body[i].idTipoProducto}">${data.body[i].descripcion}</option>`);
				console.log(data.body[i].descripcion)
			}

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})

}

/* function getCategoria() {
	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/categoriaProductos",
		contentType: 'application/json'
	})
		.done(function(data2, textStatus, jqXHR) {
			console.log("perfect");
			console.log("La solicitud se ha completado correctamente.", data2, textStatus, jqXHR);
			for (i = 0; i < data2.body.length; i++) {
				$(".option2").after(`<option value="${data2.body[i].idCategoriaProducto}">${data2.body[i].descripcion}</option>`);
				console.log(data2.body[i].descripcion)
			}
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})
}
*/