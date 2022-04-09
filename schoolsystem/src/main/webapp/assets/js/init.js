$(document).ready(function() {
	const baseUrl = $("#baseUrl").val();

	let asignaturasLoaded = false;
	let cursosLoaded = false;
	let alumnosLoaded = false;
	let profesoresLoaded = false;

	const reset = () => {
		$("#home").hide();
		$("#asignaturas").hide();
		$("#cursos").hide();
		$("#profesores").hide();
		$("#alumnos").hide();
	}

	// Load Mantenedor Alumno
	const loadMantenedorAlumno = () => {
		reset();
		if (!alumnosLoaded) {
			alumnosLoaded = true;
			$("#alumnos").load(`${baseUrl}/mantenedoralumnos.srv`);
		}
		$("#alumnos").show();
	}

	$("#idMenuMantenedorAlumno").click(function(event) {
		console.log("Click mantenedor alumno");
		loadMantenedorAlumno();
	});

	// Load Mantenedor Profesor
	const loadMantenedorProfesor = () => {
		reset();
		if (!profesoresLoaded) {
			profesoresLoaded = true;
			$("#profesores").load(`${baseUrl}/mantenedorprofesor.srv`);
		}
		$("#profesores").show();
	}

	$("#idMenuMantenedorProfesores").click(function(event) {
		console.log("Click mantenedor profesor");
		loadMantenedorProfesor();
	});

	// Load Mantenedor Curso
	const loadMantenedorCurso = () => {
		reset();
		if (!cursosLoaded) {
			cursosLoaded = true;
			$("#cursos").load(`${baseUrl}/mantenedorcurso.srv`);
		}
		$("#cursos").show();
	}

	$("#idMenuMantenedorCursos").click(function(event) {
		console.log("Click mantenedor curso");
		loadMantenedorCurso();
	});

	// Load Mantenedor Asignatura
	const loadMantenedorAsignatura = () => {
		reset();
		if (!asignaturasLoaded) {
			asignaturasLoaded = true;
			$("#asignaturas").load(`${baseUrl}/mantenedorasignatura.srv`);
		}
		$("#asignaturas").show();
	}

	$("#idMenuMantenedorAsignaturas").click(function(event) {
		console.log("Click mantenedor asignatura");
		loadMantenedorAsignatura();
	});

});