const tablaProductos = $('#idTablaProductos');
let dataCategoriaProducto;
$(document).ready(function() {

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/categoriaProductos",
		contentType: 'application/json'
	})
		.done(function(data2, textStatus, jqXHR) {
			console.log("perfect");
			console.log("La solicitud se ha completado correctamente.", data2, textStatus, jqXHR);
			dataCategoriaProducto = data2;
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})

	$(".sectionProducto").hide();
	$("#listarProductos").click(function() {
		$(".sectionProducto").show();
		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/productos",
			contentType: 'application/json'
		})
			.done(function(dataProductos, textStatus, jqXHR) {
				console.log(dataProductos);
				tablaProductos.bootstrapTable({
					data: dataProductos.body,
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
						field: 'descripcion',
						title: 'Descripcion',
						width: '180px'
					}, {
						field: 'tipoProducto.descripcion',
						title: 'Tipo',
						width: '180px'
					}, {
						field: 'categoriaProducto.descripcion',
						title: 'Categoria',
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
							return [
								"<a class='like' data-toggle='modal' data-target='#modalEditarProducto' onclick='onClickEditarProducto(\"" + JSON.stringify(row).split('"').join('\\"') + "\");getTipoProducto(editarOption1);getCategoria(editarOption2);' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>",
								"<a class='remove ms-2' data-toggle='modal' data-target='#modalEliminarProducto' onclick='onClickEliminarProducto(\"" + row.idProducto + "\");' title='Eliminar'>",
								'<i class="fa fa-trash"></i>',
								"</a>"
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
	$("#idBtnGuardarProducto").click(function() {

		const validaFormNuevoProducto = () => {

			var idTxtAgregarDescripcion = false;
			var idSelTipoProducto = false;
			var idSelCategoriaProducto = false;

			if ($("#idTxtAgregarDescripcion").val().length == 0) {
				$("#idTxtAgregarDescripcion").addClass("is-invalid");
				$("#idTxtAgregarDescripcion").removeClass("is-valid");
				idTxtAgregarDescripcion = false;
			} else {
				$("#idTxtAgregarDescripcion").removeClass("is-invalid");
				$("#idTxtAgregarDescripcion").addClass("is-valid");
				idTxtAgregarDescripcion = true;
			}
			if ($("#idSelTipoProducto").val() == null) {
				$("#idSelTipoProducto").addClass("is-invalid");
				$("#idSelTipoProducto").removeClass("is-valid");
				idSelTipoProducto = false;
			} else if ($("#idSelTipoProducto").val() <= 0) {
				$("#idSelTipoProducto").addClass("is-invalid");
				$("#idSelTipoProducto").removeClass("is-valid");
				idSelTipoProducto = false;
			} else {
				$("#idSelTipoProducto").removeClass("is-invalid");
				$("#idSelTipoProducto").addClass("is-valid");
				idSelTipoProducto = true;
			}
			if ($("#idSelCategoriaProducto").val() == null) {
				$("#idSelCategoriaProducto").addClass("is-invalid");
				$("#idSelCategoriaProducto").removeClass("is-valid");
				idSelCategoriaProducto = false;
			} else if ($("#idSelCategoriaProducto").val() <= 0) {
				$("#idSelCategoriaProducto").addClass("is-invalid");
				$("#idSelCategoriaProducto").removeClass("is-valid");
				idSelCategoriaProducto = false;
			} else {
				$("#idSelCategoriaProducto").removeClass("is-invalid");
				$("#idSelCategoriaProducto").addClass("is-valid");
				idSelCategoriaProducto = true;
			}
			return idTxtAgregarDescripcion && idSelTipoProducto && idSelCategoriaProducto;
		}

		if (validaFormNuevoProducto()) {
			console.log("Todo bien");

			let dataProducto = {
				"descripcion": $("#idTxtAgregarDescripcion").val(),
				"categoriaProducto": {
					"idCategoriaProducto": Number($("#idSelCategoriaProducto").val())
				},
				"tipoProducto": {
					"idTipoProducto": Number($("#idSelTipoProducto").val())
				}
			}

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataProducto),
				type: "POST",
				dataType: "json",
				url: "/productos",
				contentType: 'application/json;charset=UTF-8'
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

	$('#modalAgregarProducto').on('show.bs.modal', function() {
		$("#idTxtAgregarDescripcion").val("");
		$("#idTxtAgregarDescripcion").removeClass("is-valid");
		$("#idTxtAgregarDescripcion").removeClass("is-invalid");

		$("#idSelTipoProducto").val("-1");
		$("#idSelTipoProducto").removeClass("is-valid");
		$("#idSelTipoProducto").removeClass("is-invalid");

		$("#idSelCategoriaProducto").val("-1");
		$("#idSelCategoriaProducto").removeClass("is-valid");
		$("#idSelCategoriaProducto").removeClass("is-invalid");

	});

});

let dataProducto;

//Delete Producto
function onClickEliminarProducto(id) {
	console.log("Id a eliminar: " + id);
	$('#modalEliminarProducto').modal('show');
	dataProducto = {
		"idProducto": id
	};
}

$("#idBtnEliminarProducto").click(function() {

	console.log('id to delete: ' + dataProducto.idProducto);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataProducto),
		//Cambiar a type: POST si necesario
		type: "DELETE",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/productos",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			$('#modalEliminarProducto').modal('hide');
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Bodegas a refrescar", data.body);
			tablaProductos.bootstrapTable('load', data.body);
			tablaProductos.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			swal({
				text: "Producto ya eliminado",
				icon: "error"
			});
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});

function onClickEditarProducto(row) {
	dataProducto = JSON.parse(row);
	console.log(dataProducto);

	$("#idTxtEditarDescripcionProducto").val(dataProducto.descripcion);
	$("#idTxtEditarDescripcionProducto").removeClass("is-valid");
	$("#idTxtEditarDescripcionProducto").removeClass("is-invalid");

	$("#idSelEditarTipoProducto").val("-1");
	$("#idSelEditarTipoProducto").removeClass("is-valid");
	$("#idSelEditarTipoProducto").removeClass("is-invalid");

	$("#idSelEditarCategoriaProducto").val("-1");
	$("#idSelEditarCategoriaProducto").removeClass("is-valid");
	$("#idSelEditarCategoriaProducto").removeClass("is-invalid");

	$('#modalEditarProducto').modal('show');

}

$("#idBtnEditarProducto").click(function() {

	const validaFormEditarProducto = () => {

		var idTxtEditarDescripcionProducto = false;
		var idSelEditarTipoProducto = false;
		var idSelEditarCategoriaProducto = false;

		if ($("#idTxtEditarDescripcionProducto").val().length == 0) {
			$("#idTxtEditarDescripcionProducto").addClass("is-invalid");
			$("#idTxtEditarDescripcionProducto").removeClass("is-valid");
			idTxtEditarDescripcionProducto = false;
		} else {
			$("#idTxtEditarDescripcionProducto").removeClass("is-invalid");
			$("#idTxtEditarDescripcionProducto").addClass("is-valid");
			idTxtEditarDescripcionProducto = true;
		}
		if ($("#idSelEditarTipoProducto").val() == null) {
			$("#idSelEditarTipoProducto").addClass("is-invalid");
			$("#idSelEditarTipoProducto").removeClass("is-valid");
			idSelEditarTipoProducto = false;
		} else if ($("#idSelEditarTipoProducto").val() <= 0) {
			$("#idSelEditarTipoProducto").addClass("is-invalid");
			$("#idSelEditarTipoProducto").removeClass("is-valid");
			idSelEditarTipoProducto = false;
		} else {
			$("#idSelEditarTipoProducto").removeClass("is-invalid");
			$("#idSelEditarTipoProducto").addClass("is-valid");
			idSelEditarTipoProducto = true;
		}
		if ($("#idSelEditarCategoriaProducto").val() == null) {
			$("#idSelEditarCategoriaProducto").addClass("is-invalid");
			$("#idSelEditarCategoriaProducto").removeClass("is-valid");
			idSelEditarCategoriaProducto = false;
		} else if ($("#idSelEditarCategoriaProducto").val() <= 0) {
			$("#idSelEditarCategoriaProducto").addClass("is-invalid");
			$("#idSelEditarCategoriaProducto").removeClass("is-valid");
			idSelEditarCategoriaProducto = false;
		} else {
			$("#idSelEditarCategoriaProducto").removeClass("is-invalid");
			$("#idSelEditarCategoriaProducto").addClass("is-valid");
			idSelEditarCategoriaProducto = true;
		}
		return idTxtEditarDescripcionProducto && idSelEditarTipoProducto && idSelEditarCategoriaProducto;
	}

	if (validaFormEditarProducto()) {
		console.log("Todo bien");

		let dataProductoId = dataProducto.idProducto;

		dataProducto = {
			"descripcion": $("#idTxtEditarDescripcionProducto").val(),
			"categoriaProducto": {
				"idCategoriaProducto": Number($("#idSelEditarCategoriaProducto").val())
			},
			"tipoProducto": {
				"idTipoProducto": Number($("#idSelEditarTipoProducto").val())
			}
		}

		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataProducto),
			type: "PUT",
			dataType: "json",
			url: `/productos/${dataProductoId}`,
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

function getTipoProducto(option) {

	let optionParam = document.querySelector(`#${option.id}`)

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/tipoProductos",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log("perfect");
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);

			if ($(optionParam).val() === "-1") {
				$(optionParam).val("0")
				data.body.forEach((d) => {
					$(optionParam).after(`<option value="${d.idTipoProducto}">${d.descripcion}</option>`);
					console.log(d.descripcion)
				});
			}

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		})

}

function getCategoria(option) {

	let optionParam = document.querySelector(`#${option.id}`)

	if ($(optionParam).val() === "-1") {
		$(optionParam).val("0")
		dataCategoriaProducto.body.forEach((d) => {
			$(optionParam).after(`<option value="${d.idCategoriaProducto}">${d.descripcion}</option>`);
			console.log(d.descripcion)
		});
	}
}
