var $table = $('#tblListaProfesores')

$(document).ready(function() {
	const validaFormNuevoProfesor = () => {
		var txtNombre = false;
		var txtApellido = false;
		//var txtFecNacimiento = false;
		//var selCurso = false;

		if ($("#idTxtNombre").val().length == 0) {
			$("#idTxtNombre").addClass("is-invalid");
			$("#idTxtNombre").removeClass("is-valid");
			txtNombre = false;
		} else {
			$("#idTxtNombre").removeClass("is-invalid");
			$("#idTxtNombre").addClass("is-valid");
			txtNombre = true;
		}

		if ($("#idTxtApellido").val().length == 0) {
			$("#idTxtApellido").addClass("is-invalid");
			$("#idTxtApellido").removeClass("is-valid");
			txtApellido = false;
		} else {
			$("#idTxtApellido").removeClass("is-invalid");
			$("#idTxtApellido").addClass("is-valid");
			txtApellido = true;
		}

	/*	if ($("#idTxtFecNacimiento").val().length == 0) {
			$("#idTxtFecNacimiento").addClass("is-invalid");
			$("#idTxtFecNacimiento").removeClass("is-valid");
			txtFecNacimiento = false;
		} else {
			$("#idTxtFecNacimiento").removeClass("is-invalid");
			$("#idTxtFecNacimiento").addClass("is-valid");
			txtFecNacimiento = true;
		}

		if ($("#idSelCurso").val() === '-1') {
			$("#idSelCurso").addClass("is-invalid");
			$("#idSelCurso").removeClass("is-valid");
			selCurso = false;
		} else {
			$("#idSelCurso").removeClass("is-invalid");
			$("#idSelCurso").addClass("is-valid");
			selCurso = true;
		}*/

		return txtNombre && txtApellido;
	}


	console.log("ready!", profesorDtoJson);
	//console.log("ready!", JSON.parse(alumnoDtoJson).alumnos[0].nombre);

	$table.bootstrapTable({
		data: JSON.parse(profesorDtoJson).profesores,
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10],
		locale: "es-ES",
		columns: [{
			field: 'id_profesor',
			title: 'ID',
			width: '40px'
		}, {
			field: 'nombre',
			title: 'Nombre',
			width: '180px'
		}, {
			field: 'apellido',
			title: 'Apellido',
			width: '180px'
		}, 
		/*	{field: 'fechaNac',
			title: 'Fecha Nacimiento',
			width: '180px',
			formatter: function(value, row, index) {
				//Aqui defines el boton y en tu caso tendras que ponerle el onClick, 
				//recuerda que row tiene el objeto del renglon actual, 
				//en este ejemplo agrege funcionPorDefinir y le envio el row.id
				var fechaSplit = value.split("-");

				return fechaSplit[2] + "-" + fechaSplit[1] + "-" + fechaSplit[0];
			}
		}, {
			field: 'curso.descripcion',
			title: 'Curso',
			width: '180px'
		},*/ 
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
					"<a class='like' href='#' data-toggle='modal' data-target='#modalEditarProfesor' onclick='onClickEditar(\"" + JSON.stringify(row).split('"').join('\\"') + "\");' title='Like'>",
					"<i class='bi bi-pencil'></i>",
					"</a>  ",
					"<a class='remove' href='#'data-toggle='modal' data-target='#modalEliminarProfesor' onclick='onClickEliminar(\"" + row.id_profesor + "\");' title='Eliminar'>",
					'<i class="fa fa-trash"></i>',
					'</a>'
				].join('');
			}
		}
		]
	});

	$("#idBtnGuardarCurso").click(function() {
		var dataProfesor = {
			"nombre": $("#idTxtNombre").val(),
			"apellido": $("#idTxtApellido").val(),
			//"fechaNac": $("#idTxtFecNacimiento").val(),
			//"idCurso": $("#idSelCurso").val()
		};
		console.log("DataProfesor: ", dataProfesor);

		if (validaFormNuevoProfesor()) {
			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: { dataProfesor, "accion": "crearProfesor" },
				//Cambiar a type: POST si necesario
				type: "PUT",
				// Formato de datos que se espera en la respuesta
				dataType: "json",
				// URL a la que se enviará la solicitud Ajax
				url: "/schoolsystem-1.0.0/mantenedorprofesores.srv",
			})
				.done(function(data, textStatus, jqXHR) {
					alert(data.mensajeNuevoProfesor);
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					console.log("Profesores a refrescar", data.profesores);
					$table.bootstrapTable('load', data.profesores);
					$table.bootstrapTable('refresh');

				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				});
		}

	});

	$("#idTxtNombre").bind('keypress', function(e) {
		var keyCode = (e.which) ? e.which : e.keyCode
		console.log(keyCode);
		//return !(keyCode > 31 && (keyCode < 48 || keyCode > 90) && (keyCode < 97 || keyCode > 122));
		return (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || keyCode === 180;
	});
});

let profesorDto;

function onClickEditar(row) {
	//let rowObj = JSON.parse(row);
	profesorDto = JSON.parse(row);

	//Limpiar campos del modal
	$("#idTxtEditarNombre").val("");
	$("#idTxtEditarNombre").attr("placeholder", profesorDto.nombre);
	$("#idTxtEditarApellido").val("")
	$("#idTxtEditarApellido").attr("placeholder", profesorDto.apellido);
	//$("#idTxtEditarFecNacimiento").val("")

	console.log("Editar Json string:... ", row);
	console.log("Editar Json object:... ", profesorDto);
	//console.log(rowObj.orden_id);

}

$("#idBtnEditarProfesor").click(function() {

	var dataProfesor = {
		"id_profesor": profesorDto.id_profesor,
		"nombre": $("#idTxtEditarNombre").val(),
		"apellido": $("#idTxtEditarApellido").val(),
		//"fechaNac": $("#idTxtEditarFecNacimiento").val(),
		//"idCurso": $("#idSelEditarCurso").val()
	};

	console.log(dataProfesor.id_profesor);

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: { dataProfesor, "accion": "actualizarProfesor" },
		//Cambiar a type: POST si necesario
		type: "PUT",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/schoolsystem-1.0.0/mantenedorpofesores.srv",
	})
		.done(function(data, textStatus, jqXHR) {
			alert(data.mensaje);
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Profesores a refrescar", data.profesores);
			$table.bootstrapTable('load', data.profesores);
			$table.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});

var dataProfesor;

function onClickEliminar(id) {
	console.log("Id a eliminar: " + id);

	dataProfesor = {
		"id_profesor": id
	};


}


$("#idBtnEliminarProfesor").click(function() {

	$.ajax({
		// En data puedes utilizar un objeto JSON, un array o un query string
		data: { dataProfesor, "accion": "eliminarProfesor" },
		//Cambiar a type: POST si necesario
		type: "PUT",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/schoolsystem-1.0.0/mantenedorprofesores.srv",
	})
		.done(function(data, textStatus, jqXHR) {
			alert(data.mensaje);
			console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
			console.log("Profesores a refrescar", data.profesores);
			$table.bootstrapTable('load', data.profesores);
			$table.bootstrapTable('refresh');

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

});