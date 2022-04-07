$(document).ready(function() {

	// Load Mantenedor Alumno
	const loadMantenedorAlumno = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedoralumnos.srv');
	}

	$("#idMenuMantenedorAlumno").click(function(event) {
		console.log("Click mantenedor alumno");
		loadMantenedorAlumno();
	});

	// Load Mantenedor Profesor
	const loadMantenedorProfesor = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorprofesor.srv');
	}

	$("#idMenuMantenedorProfesores").click(function(event) {
		console.log("Click mantenedor profesor");
		loadMantenedorProfesor();
	});

	// Load Mantenedor Curso
	const loadMantenedorCurso = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorcurso.srv');
	}

	$("#idMenuMantenedorCursos").click(function(event) {
		console.log("Click mantenedor curso");
		loadMantenedorCurso();
	});

	// Load Mantenedor Asignatura
	const loadMantenedorAsignatura = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorasignatura.srv');
	}

	$("#idMenuMantenedorAsignaturas").click(function(event) {
		console.log("Click mantenedor asignatura");
		loadMantenedorAsignatura();
	});

});