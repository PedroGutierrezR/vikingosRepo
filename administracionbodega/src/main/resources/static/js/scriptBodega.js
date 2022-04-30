const tableBodega = $("#myTableBodega");
const tableMateriales = $("#myTableMateriales");

$(document).ready(function() {

	$("#listarBodegas").click(function() {

		$.ajax({
			type: "GET",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/bodegas",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				tableBodega.bootstrapTable({
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
						field: 'nombreBodega',
						title: 'Nombre',
						width: '180px'
					},
					{
						field: 'fechaIngreso',
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
								"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarBodega' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarBodega' onclick='onClickEliminar(\"" + row.idBodega + "\");' title='Eliminar'>",
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

	$("#idBtnGuardarBodega").click(function() {

		const validaFormNuevaBodega = () => {

			var idTxtAgregarNombreBodega = false;
			var idTxtAgregarFecha = false;

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
			return idTxtAgregarNombreBodega & idTxtAgregarFecha;
		}

		let dataBodega = {
			"nombreBodega": $("#idTxtAgregarNombreBodega").val(),
			"fechaIngreso": $("#idTxtAgregarFecha").val(),
		}

		console.log(dataBodega);

		if (validaFormNuevaBodega()) {
			console.log("Todo bien");

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataBodega),
				//Cambiar a type: POST si necesario
				type: "POST",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/bodegas",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
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
				});

		} else {
			console.log("Nada");
		}

	});

	$('#modalNuevaBodega').on('show.bs.modal', function() {
		$("#idTxtAgregarNombreBodega").val("");
		$("#idTxtAgregarNombreBodega").removeClass("is-valid");
		$("#idTxtAgregarNombreBodega").removeClass("is-invalid");

		$("#idTxtAgregarFecha").val("");
		$("#idTxtAgregarFecha").removeClass("is-valid");
		$("#idTxtAgregarFecha").removeClass("is-invalid");

	});

});

// Global variable
let dataBodega;

//Edit Bodega
function onClickEditar(row) {
	dataBodega = JSON.parse(row);

	//Limpiar campos del modal
	$("#idTxtEditarNombreBodega").val(dataBodega.nombreBodega);
	$("#idTxtEditarNombreBodega").removeClass("is-valid");
	$("#idTxtEditarNombreBodega").removeClass("is-invalid");

	$("#idTxtEditarFecha").val(dataBodega.fechaIngreso);
	$("#idTxtEditarFecha").removeClass("is-valid");
	$("#idTxtEditarFecha").removeClass("is-invalid");
	console.log(dataBodega);

}

$("#idBtnEditarBodega").click(function() {

	const validaFormEditarBodega = () => {

		var idTxtEditarNombreBodega = false;
		var idTxtEditarFecha = false;

		if ($("#idTxtEditarNombreBodega").val().length == 0) {
			$("#idTxtEditarNombreBodega").addClass("is-invalid");
			$("#idTxtEditarNombreBodega").removeClass("is-valid");
			idTxtEditarNombreBodega = false;
		} else {
			$("#idTxtEditarNombreBodega").removeClass("is-invalid");
			$("#idTxtEditarNombreBodega").addClass("is-valid");
			idTxtEditarNombreBodega = true;
		}

		if ($("#idTxtEditarFecha").val().length == 0) {
			$("#idTxtEditarFecha").addClass("is-invalid");
			$("#idTxtEditarFecha").removeClass("is-valid");

			idTxtEditarFecha = false;
		} else {
			$("#idTxtEditarFecha").removeClass("is-invalid");
			$("#idTxtEditarFecha").addClass("is-valid");
			idTxtEditarFecha = true;
		}

		return idTxtEditarNombreBodega && idTxtEditarFecha;
	}

	dataBodega = {
		"idBodega": dataBodega.idBodega,
		"nombreBodega": $("#idTxtEditarNombreBodega").val(),
		"fechaIngreso": $("#idTxtEditarFecha").val(),
	}

	if (validaFormEditarBodega()) {
		console.log(dataBodega);
		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: JSON.stringify(dataBodega),
			//Cambiar a type: POST si necesario
			type: "PUT",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: "/bodegas",
			contentType: 'application/json'
		})
			.done(function(data, textStatus, jqXHR) {
				swal({
					text: data.messageList[0].message,
					icon: "success"
				});
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Bodegas a refrescar", data.body);
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


//Delete Bodega
function onClickEliminar(id) {
	console.log("Id a eliminar: " + id);

	dataBodega = {
		"idBodega": id
	};
}

$("#idBtnEliminarBodega").click(function() {

	console.log('id to delete: ' + dataBodega.idBodega);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: JSON.stringify(dataBodega),
		//Cambiar a type: POST si necesario
		type: "DELETE",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/bodegas",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			swal({
				text: data.messageList[0].message,
				icon: "success"
			});
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Bodegas a refrescar", data.body);
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

function getBodegas() {
	$.ajax({
		type: "GET",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/bodegas",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			actualizarBodegaSelect(data);
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});
} 

function actualizarBodegaSelect(data) {
	let elementos = document.getElementsByTagName("option");
	console.log(elementos);
	if (elementos.length == 1) {
		for (i = 0; i < data.body.length; i++) {

			$("#option1").after(`<option value="${data.body[i].idBodega}">${data.body[i].nombreBodega}</option>`);
			console.log(data.body[i].nombreBodega)
		}
	}
}
