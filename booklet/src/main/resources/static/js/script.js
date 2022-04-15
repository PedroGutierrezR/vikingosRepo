const table = $("#myTable")

$(document).ready(function() {

	table.bootstrapTable({
		data: JSON.parse(listaLibrosDto).listaLibros,
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10],
		locale: "es-ES",
		columns: [{
			field: 'id',
			title: 'ID',
			width: '40px'
		}, {
			field: 'titulo',
			title: 'Título',
			width: '180px'
		},
		{
			field: 'anio',
			title: 'Año',
			width: '180px'
		},
		{
			field: 'autor',
			title: 'Autor',
			width: '180px'
		},
		{
			field: 'imprenta',
			title: 'Imprenta',
			width: '180px'
		},
		{
			field: 'disponibilidad',
			title: 'Disponibilidad',
			width: '180px'
		},
		{
			field: '',
			title: 'Acción',
			align: 'center',
			valign: 'middle',
			width: '150px',
			clickToSelect: false,
			formatter: function(value, row, index) {
				//Aqui defines el boton y en tu caso tendras que ponerle el onClick, 
				//recuerda que row tiene el objeto del renglon actual, 
				//en este ejemplo agrege funcionPorDefinir y le envio el row.id
				console.log(JSON.stringify(row));
				console.log($.param(row))
				return [
					"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarCurso' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
					"<i class='bi bi-pencil'></i>",
					"</a>  "
				].join('');
			}
		}
		]
	});


	$("#idBtnGuardarLibro").click(function() {

		const validaFormNuevoLibro = () => {

			var idTxtAgregarTitulo = false;
			var idTxtAgregarAnio = false;
			var idTxtAgregarAutor = false;
			var idTxtAgregarImprenta = false;
			var idTxtAgregarDisponibilidad = false;

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

			if ($("#idTxtAgregarDisponibilidad").val().length == 0) {
				$("#idTxtAgregarDisponibilidad").addClass("is-invalid");
				$("#idTxtAgregarDisponibilidad").removeClass("is-valid");
				idTxtAgregarDisponibilidad = false;
			} else {
				$("#idTxtAgregarDisponibilidad").removeClass("is-invalid");
				$("#idTxtAgregarDisponibilidad").addClass("is-valid");
				idTxtAgregarDisponibilidad = true;
			}
			return idTxtAgregarTitulo && idTxtAgregarAnio && idTxtAgregarAutor && idTxtAgregarImprenta && idTxtAgregarDisponibilidad;
		}

		let dataLibro = {
			"titulo": $("#idTxtAgregarTitulo").val(),
			"anio": $("#idTxtAgregarAnio").val(),
			"autor": $("#idTxtAgregarAutor").val(),
			"imprenta": $("#idTxtAgregarImprenta").val(),
			"disponibilidad": $("#idTxtAgregarDisponibilidad").val(),
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
					console.log("Cursos a refrescar", data.listaLibros);
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

		$("#idTxtAgregarDisponibilidad").val("");
		$("#idTxtAgregarDisponibilidad").removeClass("is-valid");
		$("#idTxtAgregarDisponibilidad").removeClass("is-invalid");
	});

});
