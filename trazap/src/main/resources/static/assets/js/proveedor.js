/**
let tablaProveedor = $('#idTablaProveedor');
$(document).ready(function() {

	$("#listarProveedores").click(function() {

		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/proveedor",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				console.log(data);
				tablaProveedor.bootstrapTable({
					data: data.body,
					pagination: true,
					search: true,
					pageSize: 5,
					pageList: [5, 10],
					locale: "es-ES",
					columns: [{
						field: 'idPoveedor',
						title: 'ID',
						width: '40px'
					}, {
						field: 'rut_proveedor',
						title: 'Rut',
						width: '180px'
					}, {
						field: 'razon_social',
						title: 'Razon Social',
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
								"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarProveedor' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarProveedor' onclick='onClickEliminar(\"" + row.idPoveedor + "\");' title='Eliminar'>",
								'<i class="fa fa-trash"></i>',
								'</a>',
								"<input style='border-radius: 5px;' type='button' value='Ver productos' class='ver ms-3' href='#' data-toggle='modal' data-target='#modalVerProductos' onclick='onClickVerProductos(\"" + row.idPoveedor + "\");' title='Ver Productos'>",
								'</input>',
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

});

$("#idBtnAgregarProveedor").click(function() {

	const validaFormNuevoProveedor = () => {

		var idTxtAgregarRutProveedor = false;
		var idTxtAgregarRazonSocial = false;
		var idTxtAgregarProductoProveedor = false;

		if ($("#idTxtAgregarRutProveedor").val().length == 0) {
			$("#idTxtAgregarRutProveedor").addClass("is-invalid");
			$("#idTxtAgregarRutProveedor").removeClass("is-valid");
			idTxtAgregarRutProveedor = false;
		} else {
			$("#idTxtAgregarRutProveedor").removeClass("is-invalid");
			$("#idTxtAgregarRutProveedor").addClass("is-valid");
			idTxtAgregarRutProveedor = true;
		}

		if ($("#idTxtAgregarRazonSocial").val().length == 0) {
			$("#idTxtAgregarRazonSocial").addClass("is-invalid");
			$("#idTxtAgregarRazonSocial").removeClass("is-valid");
			idTxtAgregarRazonSocial = false;
		} else {
			$("#idTxtAgregarRazonSocial").removeClass("is-invalid");
			$("#idTxtAgregarRazonSocial").addClass("is-valid");
			idTxtAgregarRazonSocial = true;
		}
		if ($("#idTxtAgregarProductoProveedor").val().length == 0) {
			$("#idTxtAgregarProductoProveedor").addClass("is-invalid");
			$("#idTxtAgregarProductoProveedor").removeClass("is-valid");
			idTxtAgregarProductoProveedor = false;
		} else {
			$("#idTxtAgregarProductoProveedor").removeClass("is-invalid");
			$("#idTxtAgregarProductoProveedor").addClass("is-valid");
			idTxtAgregarProductoProveedor = true;
		}
		return idTxtAgregarRutProveedor & idTxtAgregarRazonSocial & idTxtAgregarProductoProveedor;
	}

	let dataProveedor = {
		"rutProveedor": $("#idTxtAgregarRutProveedor").val(),
		"razonSocial": $("#idTxtAgregarRazonSocial").val(),
		"productoProveedor": $("idTxtAgregarProductoProveedor").val(),
	}

	console.log(dataProveedor);

	if (validaFormNuevoProveedor()) {
		console.log("Todo bien");

		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataProveedor),
			//Cambiar a type: POST si necesario
			type: "POST",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/proveedor",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				getProveedor(data);
				swal({
					text: data.messageList[0].message,
					icon: "success"
				});
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				tableBodega.bootstrapTable('load', data.body);
				tableBodega.bootstrapTable('refresh');
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			})

	} else {
		console.log("Nada");
	}

});

$('#modalNuevoProveedor').on('show.bs.modal', function() {
	$("#idTxtAgregarRutProveedor").val("");
	$("#idTxtAgregarRutProveedor").removeClass("is-valid");
	$("#idTxtAgregarRutProveedor").removeClass("is-invalid");

	$("#idTxtAgregarRazonSocial").val("");
	$("#idTxtAgregarRazonSocial").removeClass("is-valid");
	$("#idTxtAgregarRazonSocial").removeClass("is-invalid");

	$("idTxtAgregarProductoProveedor").val("");
	$("idTxtAgregarProductoProveedor").removeClass("is-valid");
	$("idTxtAgregarProductoProveedor").removeClass("is-invalid");

});

// Global variable
let dataProveedor;

//Edit proveedor
function onClickEditar(row) {
	dataProveedor = JSON.parse(row);

	//Limpiar campos del modal

	$("#idTxtAgregarRutProveedor").val(dataProveedor.rutProveedor);
	$("#idTxtAgregarRutProveedor").removeClass("is-valid");
	$("#idTxtAgregarRutProveedor").removeClass("is-invalid");

	$("#idTxtAgregarRazonSocial").val(dataProveedor.razonSocial);
	$("#idTxtAgregarRazonSocial").removeClass("is-valid");
	$("#idTxtAgregarRazonSocial").removeClass("is-invalid");

	$("idTxtAgregarProductoProveedor").val(dataPorveedor.productoProveedor);
	$("idTxtAgregarProductoProveedor").removeClass("is-valid");
	$("idTxtAgregarProductoProveedor").removeClass("is-invalid");

	console.log(dataProveedor);

}

$("#idBtnEditarProveedor").click(function() {

	const validaFormEditarProveedor = () => {

		var idTxtEditarRutProveedor = false;
		var idTxtEditarRazonSocial = false;
		var idTxtEditarProductoProveedor = false;

		if ($("#idTxtEditarRutProveedor").val().length == 0) {
			$("#idTxtEditarRutProveedor").addClass("is-invalid");
			$("#idTxtEditarRutProveedor").removeClass("is-valid");
			idTxtEditarRutProveedor = false;
		} else {
			$("#idTxtEditarRutProveedor").removeClass("is-invalid");
			$("#idTxtEditarRutProveedor").addClass("is-valid");
			idTxtEditarRutProveedor = true;
		}

		if ($("#idTxtEditarRazonSocial").val().length == 0) {
			$("#idTxtEditarRazonSocial").addClass("is-invalid");
			$("#idTxtEditarRazonSocial").removeClass("is-valid");
			idTxtEditarRazonSocial = false;
		} else {
			$("#idTxtEditarRazonSocial").removeClass("is-invalid");
			$("#idTxtEditarRazonSocial").addClass("is-valid");
			idTxtEditarRazonSocial = true;
		}
		if ($("#idTxtEditarProductoProveedor").val().length == 0) {
			$("#idTxtEditarProductoProveedor").addClass("is-invalid");
			$("#idTxtEditarProductoProveedor").removeClass("is-valid");
			idTxtEditarProductoProveedor = false;
		} else {
			$("#idTxtEditarProductoProveedor").removeClass("is-invalid");
			$("#idTxtEditarProductoProveedor").addClass("is-valid");
			idTxtEditarProductoProveedor = true;
		}
		return idTxtEditarRutProveedor & idTxtEditarRazonSocial & idTxtEditarProductoProveedor;
	}

	dataProveedor = {
		"idProveedor": dataProveedor.idProveedor,
		"rutProveedor": $("#idTxtEditarRutProveedor").val(),
		"razonSocial": $("#idTxtEditarRazonSocial").val(),
		"productoProveedor": $("#idTxtEditarProductoProveedor").val(),
	}

	if (validaFormEditarProveedor()) {
		console.log(dataProveedor);
		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataProveedor),
			//Cambiar a type: POST si necesario
			type: "PUT",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/proveedor",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				getProveedor(data);
				swal({
					text: data.messageList[0].message,
					icon: "success"
				});
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Proveedor a refrescar", data.body);
				tableBodega.bootstrapTable('load', data.body);
				tableBodega.bootstrapTable('refresh');

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


//Delete Proveedor
function onClickEliminar(id) {
	console.log("Id a eliminar: " + id);

	dataProveedor = {
		"idProveedor": id
	};
}

$("#idBtnEliminarProveedor").click(function() {

	console.log('id to delete: ' + dataProveedor.idProveedor);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataProveedor),
		//Cambiar a type: POST si necesario
		type: "DELETE",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/proveedor",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			getProveedor(data);
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Proveedor a refrescar", data.body);
			tableBodega.bootstrapTable('load', data.body);
			tableBodega.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			swal({
				text: "error",
				icon: "error"
			});
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});

/*
function getProveedor(data) {
	let elementos = document.getElementsByTagName("option");
	if (elementos.length == 2) {
		for (i = 0; i < data.body.length; i++) {
			$(".option1").after(`<option value="${data.body[i].idBodega}">${data.body[i].nombreBodega}</option>`);
			console.log(data.body[i].nombreBodega)
		}
	}
}

function listarBodegas() {
	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataBodega),
		//Cambiar a type: POST si necesario
		type: "GET",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/bodegas",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			let elementos = document.getElementsByTagName("option");
			if (elementos.length == 2) {
				for (i = 0; i < data.body.length; i++) {
					$(".option1").after(`<option value="${data.body[i].idBodega}">${data.body[i].nombreBodega}</option>`);
					console.log(data.body[i].nombreBodega)
				}
			}
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})
}

function onClickVerProductos(id){
	console.log(id);
		$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataProveedor),
		//Cambiar a type: POST si necesario
		type: "GET",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/productoProveedor",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log(data);
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Proveedor a refrescar", data.body);


		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			swal({
				text: "error",
				icon: "error"
			});
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});
}
	 */
