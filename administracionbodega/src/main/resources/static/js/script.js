const table = $("#myTableBodega")

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
				//				swal({
				//					text: data.messageList[0].message,
				//					icon: "success"
				//				});
				table.bootstrapTable({
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
								"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarLibro' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
								"<i class='bi bi-pencil'></i>",
								"</a>  ",
								"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarLibro' onclick='onClickEliminar(\"" + row.id + "\");' title='Eliminar'>",
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

	//Desde aqui para abajo nada nuevo
	$("#idBtnGuardarLibro").click(function() {

		const validaFormNuevoLibro = () => {

			var idTxtAgregarTitulo = false;
			var idTxtAgregarAnio = false;
			var idTxtAgregarAutor = false;
			var idTxtAgregarImprenta = false;

			if ($("#idTxtAgregarTitulo").val().length == 0) {
				$("#idTxtAgregarTitulo").addClass("is-invalid");
				$("#idTxtAgregarTitulo").removeClass("is-valid");
				idTxtAgregarTitulo = false;
			} else {
				$("#idTxtAgregarTitulo").removeClass("is-invalid");
				$("#idTxtAgregarTitulo").addClass("is-valid");
				idTxtAgregarTitulo = true;
			}

			if ($("#idTxtAgregarAnio").val().length == 0) {
				$("#idTxtAgregarAnio").addClass("is-invalid");
				$("#idTxtAgregarAnio").removeClass("is-valid");
				idTxtAgregarAnio = false;
			} else {
				$("#idTxtAgregarAnio").removeClass("is-invalid");
				$("#idTxtAgregarAnio").addClass("is-valid");
				idTxtAgregarAnio = true;
			}

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

			return idTxtAgregarTitulo && idTxtAgregarAnio && idTxtAgregarAutor && idTxtAgregarImprenta;
		}

		let dataLibro = {
			"titulo": $("#idTxtAgregarTitulo").val(),
			"anio": $("#idTxtAgregarAnio").val(),
			"autor": $("#idTxtAgregarAutor").val(),
			"imprenta": $("#idTxtAgregarImprenta").val(),
			"disponibilidad": $("#idTxtAgregarDisponible").val(),
		}

		if ($('#idTxtAgregarNoDisponible').is(':checked')) {
			console.log("Entré");
			dataLibro.disponibilidad = $("#idTxtAgregarNoDisponible").val();
		}

		console.log(dataLibro);

		if (validaFormNuevoLibro()) {
			console.log("Todo bien");

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataLibro),
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/addBook",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
					swal({
						text: data.mensaje,
						icon: "success"
					});
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					table.bootstrapTable('load', data.listaLibros);
					table.bootstrapTable('refresh');

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});

		} else {
			console.log("Nada");
		}

	});

	$('#modalNuevoLibro').on('show.bs.modal', function() {
		$("#idTxtAgregarTitulo").val("");
		$("#idTxtAgregarTitulo").removeClass("is-valid");
		$("#idTxtAgregarTitulo").removeClass("is-invalid");

		$("#idTxtAgregarAnio").val("");
		$("#idTxtAgregarAnio").removeClass("is-valid");
		$("#idTxtAgregarAnio").removeClass("is-invalid");

		$("#idTxtAgregarAutor").val("");
		$("#idTxtAgregarAutor").removeClass("is-valid");
		$("#idTxtAgregarAutor").removeClass("is-invalid");

		$("#idTxtAgregarImprenta").val("");
		$("#idTxtAgregarImprenta").removeClass("is-valid");
		$("#idTxtAgregarImprenta").removeClass("is-invalid");

	});

	// Global variable
	let dataLibro;

	//Edit Book
	function onClickEditar(row) {

		dataLibro = JSON.parse(row);

		//Limpiar campos del modal
		$("#idTxtTitulo").val(dataLibro.titulo);
		$("#idTxtTitulo").removeClass("is-valid");
		$("#idTxtTitulo").removeClass("is-invalid");

		$("#idTxtAnio").val(dataLibro.anio);
		$("#idTxtAnio").removeClass("is-valid");
		$("#idTxtAnio").removeClass("is-invalid");

		$("#idTxtAutor").val(dataLibro.autor);
		$("#idTxtAutor").removeClass("is-valid");
		$("#idTxtAutor").removeClass("is-invalid");

		$("#idTxtImprenta").val(dataLibro.imprenta);
		$("#idTxtImprenta").removeClass("is-valid");
		$("#idTxtImprenta").removeClass("is-invalid");

		$("#idTxtDisponible").removeClass("is-valid");
		$("#idTxtDisponible").removeClass("is-invalid");
		$("#idTxtNoDisponible").removeClass("is-valid");
		$("#idTxtNoDisponible").removeClass("is-invalid");

		if (dataLibro.disponibilidad === "Disponible") {
			console.log("Hola: " + dataLibro.disponibilidad);
			$("#idTxtNoDisponible").prop('checked', false);
			$("#idTxtDisponible").prop('checked', true);
		} else if (dataLibro.disponibilidad === "No disponible") {
			console.log("Hola: " + dataLibro.disponibilidad);
			$("#idTxtDisponible").prop('checked', false);
			$("#idTxtNoDisponible").prop('checked', true);
		}

		$("#idTxtDisponible").change(function() {
			dataLibro.disponibilidad = $("#idTxtDisponible").val();
		});
		$("#idTxtNoDisponible").change(function() {
			dataLibro.disponibilidad = $("#idTxtNoDisponible").val();
		});

		console.log(dataLibro);

	}

	$("#idBtnEditarLibro").click(function() {

		const validaFormEditarLibro = () => {

			var idTxtTitulo = false;
			var idTxtAnio = false;
			var idTxtAutor = false;
			var idTxtImprenta = false;

			if ($("#idTxtTitulo").val().length == 0) {
				$("#idTxtTitulo").addClass("is-invalid");
				$("#idTxtTitulo").removeClass("is-valid");
				idTxtTitulo = false;
			} else {
				$("#idTxtTitulo").removeClass("is-invalid");
				$("#idTxtTitulo").addClass("is-valid");
				idTxtTitulo = true;
			}

			if ($("#idTxtAnio").val().length == 0) {
				$("#idTxtAnio").addClass("is-invalid");
				$("#idTxtAnio").removeClass("is-valid");
				idTxtAgregarAnio = false;
			} else {
				$("#idTxtAnio").removeClass("is-invalid");
				$("#idTxtAnio").addClass("is-valid");
				idTxtAnio = true;
			}

			if ($("#idTxtAutor").val().length == 0) {
				$("#idTxtAutor").addClass("is-invalid");
				$("#idTxtAutor").removeClass("is-valid");
				idTxtAutor = false;
			} else {
				$("#idTxtAutor").removeClass("is-invalid");
				$("#idTxtAutor").addClass("is-valid");
				idTxtAutor = true;
			}

			if ($("#idTxtImprenta").val().length == 0) {
				$("#idTxtImprenta").addClass("is-invalid");
				$("#idTxtImprenta").removeClass("is-valid");
				idTxtImprenta = false;
			} else {
				$("#idTxtImprenta").removeClass("is-invalid");
				$("#idTxtImprenta").addClass("is-valid");
				idTxtImprenta = true;
			}

			return idTxtTitulo && idTxtAnio && idTxtAutor && idTxtImprenta;
		}

		dataLibro = {
			"id": dataLibro.id,
			"titulo": $("#idTxtTitulo").val(),
			"anio": $("#idTxtAnio").val(),
			"autor": $("#idTxtAutor").val(),
			"imprenta": $("#idTxtImprenta").val(),
			"disponibilidad": dataLibro.disponibilidad
		}

		if (validaFormEditarLibro()) {
			console.log(dataLibro);
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataLibro),
				//Cambiar a type: POST si necesario
				type: "PATCH",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/updateBook",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
					swal({
						text: data.mensaje,
						icon: "success"
					});
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Libros a refrescar", data.listaLibros);
					table.bootstrapTable('load', data.listaLibros);
					table.bootstrapTable('refresh');

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

	//Delete Book
	function onClickEliminar(id) {
		console.log("Id a eliminar: " + id);

		dataLibro = {
			"id": id
		};
	}

	$("#idBtnEliminarLibro").click(function() {

		console.log('id to delete: ' + dataLibro.id);

		$.ajax({
			//Cambiar a type: POST si necesario
			type: "DELETE",
			// URL a la que se enviará la solicitud Ajax
			url: " /deleteBook?idLibro=" + dataLibro.id,
		})
			.done(function(data, textStatus, jqXHR) {
				if (data.mensaje == "Eliminado Correctamente") {
					swal({
						text: data.mensaje,
						icon: "success"
					});
				} else {
					swal({
						text: data.mensaje,
						icon: "error"
					});
				}

				console.log(data.mensaje);
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Libros a refrescar", data.listaLibros);
				table.bootstrapTable('load', data.listaLibros);
				table.bootstrapTable('refresh');
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});

	});
});