 $(document).ready(function() {
	const loadMantenedorAlumno = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedoralumnos.srv');
	}


	$("#idMenuMantenedorAlumno").click(function(event) {
		console.log("Click mantenedor alumno");
		loadMantenedorAlumno();
	});

	const loadMantenedorProfesor = () => {
		$("#idContenido").load('/schoolsystem-1.0.0/mantenedorprofesor.srv');
	}


	$("#idMenuMantenedorProfesores").click(function(event) {
		console.log("Click mantenedor profesor");
		loadMantenedorProfesor();
	});
	



});