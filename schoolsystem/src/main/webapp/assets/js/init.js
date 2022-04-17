<<<<<<< HEAD
 $(document).ready(function() {
=======
$(document).ready(function() {

	// Load Mantenedor Alumno
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	const loadMantenedorAlumno = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedoralumnos.srv');
	}

<<<<<<< HEAD

=======
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	$("#idMenuMantenedorAlumno").click(function(event) {
		console.log("Click mantenedor alumno");
		loadMantenedorAlumno();
	});

<<<<<<< HEAD
	const loadMantenedorProfesor = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorprofesor.srv');
	}


=======
	// Load Mantenedor Profesor
	const loadMantenedorProfesor = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorprofesores.srv');
	}

>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8
	$("#idMenuMantenedorProfesores").click(function(event) {
		console.log("Click mantenedor profesor");
		loadMantenedorProfesor();
	});
<<<<<<< HEAD
	


=======

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
>>>>>>> ff4cdbbcbfa9bc2e3220adb87e5f870fec4366e8

});