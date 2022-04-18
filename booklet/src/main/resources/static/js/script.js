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
					"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarLibro' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
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
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("libros a refrescar", data.listaLibros);
					$table.bootstrapTable('load', data.listaLibros);
					$table.bootstrapTable('refresh');

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});

		} else {
			console.log("Nada");
		}

	});

});

let libroDto;

function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	libroDto = JSON.parse(row);

	//Limpiar campos del modal
	$("#idTxtTitulo").val("");
	$("#idTxtTitulo").attr("placeholder", libroDto.titulo);
	$("#idTxtAnio").val("")
	$("#idTxtAnio").attr("placeholder", libroDto.anio);
	$("#idTxtAutor").val("")
	$("#idTxtAutor").attr("placeholder", libroDto.autor);
	$("#idTxtImprenta").val("")
	$("#idTxtImprenta").attr("placeholder", libroDto.imprenta);
	$("#idTxtDisponibilidad").val("")
	$("#idTxtDisponibilidad").attr("placeholder", libroDto.disponibilidad);

	console.log("Editar Json string:... ", row);
	console.log("Editar Json object:... ", libroDto);
	//console.log(rowObj.orden_id);

}

$("#idBtnEditarLibro").click(function() {

	const validaFormEditarLibro = () => {

			var idTxtTitulo = false;
			var idTxtAnio = false;
			var idTxtAutor = false;
			var idTxtImprenta = false;
			var idTxtDisponibilidad = false;

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

			if ($("#idTxtDisponibilidad").val().length == 0) {
				$("#idTxtDisponibilidad").addClass("is-invalid");
				$("#idTxtDisponibilidad").removeClass("is-valid");
				idTxtDisponibilidad = false;
			} else {
				$("#idTxtDisponibilidad").removeClass("is-invalid");
				$("#idTxtDisponibilidad").addClass("is-valid");
				idTxtDisponibilidad = true;
			}
			return idTxtTitulo && idTxtAnio && idTxtAutor && idTxtImprenta && idTxtDisponibilidad;
		}

		let dataLibro = {
			"id_libro": libroDto.id_libro,
			"titulo": $("#idTxtTitulo").val(),
			"anio": $("#idTxtAnio").val(),
			"autor": $("#idTxtAutor").val(),
			"imprenta": $("#idTxtImprenta").val(),
			"disponibilidad": $("#idTxtDisponibilidad").val(),
		}

		console.log(dataLibro.id_libro);
	if (validaFormEditarLibro()) {
		
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
				alert(data.mensaje);
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("libros a refrescar", data.listaLibros);
				$table.bootstrapTable('load', data.listaLibros);
				$table.bootstrapTable('refresh');

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
	}
});

