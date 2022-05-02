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
				console.log(data);
				tableMateriales.bootstrapTable({
					data: data.body,
					pagination: true,
					search: true,
					pageSize: 5,
					pageList: [5, 10],
					locale: "es-ES",
					columns: [{
						field: 'idProducto',
						title: 'ID',
						width: '40px'
					}, {
						field: 'nombreProducto',
						title: 'Nombre',
						width: '180px'
					},
					{
						field: 'precioProducto',
						title: 'Precio producto',
						width: '180px'
					},
					{
						field: 'fechaIngreso',
						title: 'Fecha de Ingreso',
						width: '180px'
					},
					{
						field: 'bodega',
						title: 'Nombre Bodega',
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
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarMaterial' onclick='onClickEliminarMaterial(\"" + row.idProducto + "\");' title='Eliminar'>",
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

	$("#idBtnGuardarMaterial").click(function() {

		const validaFormNuevoMaterial = () => {

			var agregarMaterial = false;
			var agregarPrecio = false;
			var agregarFecha = false;
			var agregarBodega = false;

			if ($("#agregarMaterial").val().length == 0) {
				$("#agregarMaterial").addClass("is-invalid");
				$("#agregarMaterial").removeClass("is-valid");
				agregarMaterial = false;
			} else {
				$("#agregarMaterial").removeClass("is-invalid");
				$("#agregarMaterial").addClass("is-valid");
				agregarMaterial = true;
			}
			if ($("#agregarPrecio").val().length == 0) {
				$("#agregarPrecio").addClass("is-invalid");
				$("#agregarPrecio").removeClass("is-valid");
				agregarPrecio = false;
			} else {
				$("#agregarPrecio").removeClass("is-invalid");
				$("#agregarPrecio").addClass("is-valid");
				agregarPrecio = true;
			}
			if ($("#agregarFecha").val().length == 0) {
				$("#agregarFecha").addClass("is-invalid");
				$("#agregarFecha").removeClass("is-valid");
				agregarFecha = false;
			} else {
				$("#agregarFecha").removeClass("is-invalid");
				$("#agregarFecha").addClass("is-valid");
				agregarFecha = true;
			}
			if ($("#idSelBodega").val() == null) {
				$("#idSelBodega").addClass("is-invalid");
				$("#idSelBodega").removeClass("is-valid");
				agregarBodega = false;
			} else if ($("#idSelBodega").val() <= 0) {
				$("#idSelBodega").addClass("is-invalid");
				$("#idSelBodega").removeClass("is-valid");
				agregarBodega = false;
			} else {
				$("#idSelBodega").removeClass("is-invalid");
				$("#idSelBodega").addClass("is-valid");
				agregarBodega = true;
			}

			return agregarMaterial & agregarPrecio & agregarFecha & agregarBodega;
		}

		let dataMaterial = {
			"nombreProducto": $("#agregarMaterial").val(),
			"precioProducto": $("#agregarPrecio").val(),
			"fechaIngreso": $("#agregarFecha").val(),
			"bodega": {
				"idBodega": $("#idSelBodega").val()
			}
		}

		console.log(dataMaterial);

		if (validaFormNuevoMaterial()) {
			console.log("Todo bien");

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataMaterial),
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
					console.log(data.body)

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});

		} else {
			console.log("Nada");
		}

	});

	$('#modalNuevoMaterial').on('show.bs.modal', function() {
		$("#agregarMaterial").val("");
		$("#agregarMaterial").removeClass("is-valid");
		$("#agregarMaterial").removeClass("is-invalid");

		$("#agregarPrecio").val("");
		$("#agregarPrecio").removeClass("is-valid");
		$("#agregarPrecio").removeClass("is-invalid");

		$("#agregarFecha").val("");
		$("#agregarFecha").removeClass("is-valid");
		$("#agregarFecha").removeClass("is-invalid");

		$("#idSelBodega").val("-1");
		$("#idSelBodega").removeClass("is-valid");
		$("#idSelBodega").removeClass("is-invalid");
		
	});

});

// Global variable
let dataMaterial;

//Edit Material
function onClickEditarMaterial(row) {
	listarBodegas();
	dataMaterial = JSON.parse(row);

	//Limpiar campos del modal
	$("#editarMateriales").val(dataMaterial.nombreProducto);
	$("#editarMateriales").removeClass("is-valid");
	$("#editarMateriales").removeClass("is-invalid");

	$("#editarPrecio").val(dataMaterial.precioProducto);
	$("#editarPrecio").removeClass("is-valid");
	$("#editarPrecio").removeClass("is-invalid");

	$("#editarFecha").val(dataMaterial.fechaIngreso);
	$("#editarFecha").removeClass("is-valid");
	$("#editarFecha").removeClass("is-invalid");

	$("#idSelEditBodega").val("-1");
	$("#idSelEditBodega").removeClass("is-valid");
	$("#idSelEditBodega").removeClass("is-invalid");
	console.log(dataMaterial);

}

$("#idBtnEditarMaterial").click(function() {

	const validaFormEditarMaterial = () => {

		var editarMateriales = false;
		var editarPrecio = false;
		var editarFecha = false;
		var idSelEditBodega = false;

		if ($("#editarMateriales").val().length == 0) {
			$("#editarMateriales").addClass("is-invalid");
			$("#editarMateriales").removeClass("is-valid");
			editarMateriales = false;
		} else {
			$("#editarMateriales").removeClass("is-invalid");
			$("#editarMateriales").addClass("is-valid");
			editarMateriales = true;
		}

		if ($("#editarPrecio").val().length == 0) {
			$("#editarPrecio").addClass("is-invalid");
			$("#editarPrecio").removeClass("is-valid");
			editarPrecio = false;
		} else {
			$("#editarPrecio").removeClass("is-invalid");
			$("#editarPrecio").addClass("is-valid");
			editarPrecio = true;
		}
		if ($("#editarFecha").val().length == 0) {
			$("#editarFecha").addClass("is-invalid");
			$("#editarFecha").removeClass("is-valid");
			editarFecha = false;
		} else {
			$("#editarFecha").removeClass("is-invalid");
			$("#editarFecha").addClass("is-valid");
			editarFecha = true;
		}
		if ($("#idSelEditBodega").val() == null) {
			$("#idSelEditBodega").addClass("is-invalid");
			$("#idSelEditBodega").removeClass("is-valid");
			idSelEditBodega = false;
		} else if ($("#idSelEditBodega").val() <= 0) {
			$("#idSelEditBodega").addClass("is-invalid");
			$("#idSelEditBodega").removeClass("is-valid");
			idSelEditBodega = false;
		} else {
			$("#idSelEditBodega").removeClass("is-invalid");
			$("#idSelEditBodega").addClass("is-valid");
			idSelEditBodega = true;
		}

		return editarMateriales && editarPrecio && editarFecha && idSelEditBodega;
	}

	dataMaterial = {
		"idProducto": dataMaterial.idProducto,
		"nombreProducto": $("#editarMateriales").val(),
		"precioProducto": $("#editarPrecio").val(),
		"fechaIngreso": $("#editarFecha").val(),
		"bodega": {
			"idBodega": $("#idSelEditBodega").val()
		}
	}
	console.log(dataMaterial);
	if (validaFormEditarMaterial()) {

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
				console.log("Productos a refrescar", data.body);
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
		"idProducto": id
	};
}

$("#idBtnEliminarMaterial").click(function() {

	console.log('id to delete: ' + dataMaterial.idProducto);

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
			console.log("Productos a refrescar", data.body);
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

