let tablaProductos = $('#idTablaProductos');
$(document).ready(function() {

	$.ajax({
		type: "GET",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/productos",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log(data);
			tablaProductos.bootstrapTable({
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
					field: 'descripcion',
					title: 'Descripcion',
					width: '180px'
				}, {
					field: 'categoriaProducto',
					title: 'Categoria',
					width: '180px'
				}, {
					field: 'tipoProducto',
					title: 'Tipo',
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
							"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarBodega' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
							"<i class='bi bi-pencil'></i>",
							"</a>  ",
							"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarBodega' onclick='onClickEliminar(\"" + row.idProducto + "\");' title='Eliminar'>",
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

		let dataProducto = {
			"descripcion": $("#idTxtAgregarDescripcion").val(),
			"tipoProducto": {
				"idTipoProducto": $("#idSelTipoProducto").val()
			},
			"categoriaProducto": {
				"idCategoriaProducto": $("#idSelCategoriaProducto").val()
			}
		}

		console.log(dataProducto);

		if (validaFormNuevoProducto()) {
			console.log("Todo bien");

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataProducto),
				//Cambiar a type: POST si necesario
				type: "POST",
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

function getTipoProducto() {

	$.ajax({
		type: "GET",
		dataType: "json",
		url: "/tipoProductos",
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

function getCategoria() {
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
