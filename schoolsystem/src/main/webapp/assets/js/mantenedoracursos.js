var $table = $('#tblListaCursos')

$(document).ready(function() {
	const validaFormNuevoCurso = () => {

		var idTxtAgregarNumeroNivel = false;
		var idTxtAgregarNivel = false;

		if ($("#idTxtAgregarNumeroNivel").val().length == 0) {
			$("#idTxtAgregarNumeroNivel").addClass("is-invalid");
			$("#idTxtAgregarNumeroNivel").removeClass("is-valid");
			idTxtAgregarNumeroNivel = false;
		} else {
			$("#idTxtAgregarNumeroNivel").removeClass("is-invalid");
			$("#idTxtAgregarNumeroNivel").addClass("is-valid");
			idTxtAgregarNumeroNivel = true;
		}

		if ($("#idTxtAgregarNivel").val().length == 0) {
			$("#idTxtAgregarNivel").addClass("is-invalid");
			$("#idTxtAgregarNivel").removeClass("is-valid");
			idTxtAgregarNivel = false;
		} else {
			$("#idTxtAgregarNivel").removeClass("is-invalid");
			$("#idTxtAgregarNivel").addClass("is-valid");
			idTxtAgregarNivel = true;
		}

		if ($("#idTxtAgregarABC").val().length == 0) {
			$("#idTxtAgregarABC").addClass("is-invalid");
			$("#idTxtAgregarABC").removeClass("is-valid");
			idTxtAgregarABC = false;
		} else {
			$("#idTxtAgregarABC").removeClass("is-invalid");
			$("#idTxtAgregarABC").addClass("is-valid");
			idTxtAgregarABC = true;
		}
		return idTxtAgregarNumeroNivel && idTxtAgregarNivel && idTxtAgregarABC;
	}


	console.log("ready!", cursoDtoJson);

	$table.bootstrapTable({
		data: JSON.parse(cursoDtoJson).cursos,
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10],
		locale: "es-ES",
		columns: [{
			field: 'idCurso',
			title: 'ID',
			width: '40px'
		}, {
			field: 'descripcion',
			title: 'Descripcion',
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

	$("#idBtnGuardarCurso").click(function() {

		var dataCurso = {
			"numeroNivel": $("#idTxtAgregarNumeroNivel").val(),
			"nivel": $("#idTxtAgregarNivel").val(),
			"ABC": $("#idTxtAgregarABC").val()
		};
		console.log("DataCurso: ", dataCurso);

		if (validaFormNuevoCurso()) {
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: { dataCurso, "accion": "crearCurso" },
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/schoolsystem-1.0.0/mantenedorcurso.srv",
			})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensaje);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Cursos a refrescar", data.cursos);
					$table.bootstrapTable('load', data.cursos);
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

let cursoDto;

function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	cursoDto = JSON.parse(row);

	//Limpiar campos del modal
	$("#idTxtEditarDescripcion").val("");
	$("#idTxtEditarDescripcion").attr("placeholder", "algo");

	console.log("Editar Json string:... ", row);
	console.log("Editar Json object:... ", cursoDto);
	//console.log(rowObj.orden_id);

}

$("#idBtnEditarCurso").click(function() {

	var dataCurso = {
		"idCurso": cursoDto.idCurso,
		"numeroNivel": $("#idTxtNumeroNivel").val(),
		"nivel": $("#idTxtNivel").val(),
		"ABC": $("#idTxtABC").val()
	};

	console.log(dataCurso);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: { dataCurso, "accion": "actualizarCurso" },
		//Cambiar a type: POST si necesario
		type: "PUT",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/schoolsystem-1.0.0/mantenedorcurso.srv",
	})
		.done(function(data, textStatus, jqXHR) {
			console.log("Data: " + data.mensaje);
			alert(data.mensaje);
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Cursos a refrescar", data.cursos);
			$table.bootstrapTable('load', data.cursos);
			$table.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});





