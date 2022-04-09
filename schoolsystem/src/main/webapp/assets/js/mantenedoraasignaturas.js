var $table = $('#tblListaAsignaturas')
const baseUrl = $("#baseUrl").val();

$(document).ready(function() {
	const validaFormNuevoCurso = () => {

		var idTxtDescripcionAsignatura = false;
		var idSelAgregarAsignatura = false;
		
		if ($("#idTxtDescripcionAsignatura").val().length == 0) {
			$("#idTxtDescripcionAsignatura").addClass("is-invalid");
			$("#idTxtDescripcionAsignatura").removeClass("is-valid");
			idTxtDescripcionAsignatura = false;
		} else {
			$("#idTxtDescripcionAsignatura").removeClass("is-invalid");
			$("#idTxtDescripcionAsignatura").addClass("is-valid");
			idTxtDescripcionAsignatura = true;
		}

		if ($("#idSelAgregarAsignatura").val().length == 0) {
			$("#idSelAgregarAsignatura").addClass("is-invalid");
			$("#idSelAgregarAsignatura").removeClass("is-valid");
			idSelAgregarAsignatura = false;
		} else {
			$("#idSelAgregarAsignatura").removeClass("is-invalid");
			$("#idSelAgregarAsignatura").addClass("is-valid");
			idSelAgregarAsignatura = true;
		}

		return idTxtDescripcionAsignatura && idSelAgregarAsignatura;
	}


	console.log("ready! ", asignaturaDtoJson);
	
	$table.bootstrapTable({
		data: JSON.parse(asignaturaDtoJson).asignaturas,
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10],
		locale: "es-ES",
		columns: [{
			field: 'idAsignatura',
			title: 'ID',
			width: '40px'
		}, {
			field: 'descripcion',
			title: 'Descripcion',
			width: '180px'
		}, {
			field: 'tipoAsignatura.descripcion',
			title: 'Tipo de asignatura',
			width: '180px'
		}, {
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

	$("#idBtnGuardarAsignatura").click(function() {

		var dataAsignatura = {
			"descripcion": $("#idTxtDescripcionAsignatura").val(),
			"idTipoAsignatura": $("#idSelAgregarAsignatura").val()
		};
		console.log("DataAsignatura: ", dataAsignatura);

		if (validaFormNuevoCurso()) {
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: { dataAsignatura, "accion": "crearAsignatura" },
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: `${baseUrl}/mantenedorasignatura.srv`,
			})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Asignaturas a refrescar", data.asignaturas);
					$table.bootstrapTable('load', data.asignaturas);
					$table.bootstrapTable('refresh');

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});
		}

	});

	/* 	$("#idTxtDescipcion").bind('keypress', function(e) {
			var keyCode = (e.which) ? e.which : e.keyCode
			console.log(keyCode);
			//return !(keyCode > 31 && (keyCode < 48 || keyCode > 90) && (keyCode < 97 || keyCode > 122));
			return (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || keyCode === 180;
		}); */
});

let asignaturaDto;

function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	asignaturaDto = JSON.parse(row);
	//Limpiar campos del modal
	$("#idTxtActualizarDescripcion").val("");
	$("#idTxtActualizarDescripcion").attr("placeholder", "Campo actual: " + asignaturaDto.descripcion);
	$("#idTxtActualizarDescripcion").removeClass("is-valid");
	$("#idSelActualizarAsignatura").removeClass("is-valid");

	console.log("Editar Json string:... ", row);
	console.log("Editar Json object:... ", asignaturaDto);
	//console.log(rowObj.orden_id);

}

$("#idBtnActualizarAsignatura").click(function() {

	const validaFormEditarAsignatura = () => {

		var idTxtActualizarDescripcion = false;
		var idSelActualizarAsignatura = false;
		
		if ($("#idTxtActualizarDescripcion").val().length == 0) {
			$("#idTxtActualizarDescripcion").addClass("is-invalid");
			$("#idTxtActualizarDescripcion").removeClass("is-valid");
			idTxtActualizarDescripcion = false;
		} else {
			$("#idTxtActualizarDescripcion").removeClass("is-invalid");
			$("#idTxtActualizarDescripcion").addClass("is-valid");
			idTxtActualizarDescripcion = true;
		}

		if ($("#idSelActualizarAsignatura").val().length == 0) {
			$("#idSelActualizarAsignatura").addClass("is-invalid");
			$("#idSelActualizarAsignatura").removeClass("is-valid");
			idSelActualizarAsignatura = false;
		} else {
			$("#idSelActualizarAsignatura").removeClass("is-invalid");
			$("#idSelActualizarAsignatura").addClass("is-valid");
			idSelActualizarAsignatura = true;
		}

		return idTxtActualizarDescripcion && idSelActualizarAsignatura;
	}


		var dataAsignatura = {
			"idAsignatura": asignaturaDto.idAsignatura,
			"descripcion": $("#idTxtActualizarDescripcion").val(),
			"idTipoAsignatura": $("#idSelActualizarAsignatura").val()
		};

	console.log(dataAsignatura);
	
	if (validaFormEditarAsignatura()) {
		$.ajax({
			// En data puedes utilizar un objeto JSON, un array o un query string
			data: { dataAsignatura, "accion": "actualizarAsignatura" },
			//Cambiar a type: POST si necesario
			type: "PUT",
			// Formato de datos que se espera en la respuesta
			dataType: "json",
			// URL a la que se enviará la solicitud Ajax
			url: `${baseUrl}/mantenedorasignatura.srv`,
		})
			.done(function(data, textStatus, jqXHR) {
				console.log("Data: " + data.mensaje);
				alert(data.mensaje);
				console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
				console.log("Cursos a refrescar", data.asignaturas);
				$table.bootstrapTable('load', data.asignaturas);
				$table.bootstrapTable('refresh');

			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
			});
	}
});





