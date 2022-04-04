<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
<link rel="stylesheet" href="assets/css/init.css" />
<script src="assets/js/mantenedoralumnos.js"></script>


<title>Mantenedor Profesores</title>

</head>
<body>
<header id="idHeader">
        <nav id="menu" class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Imagen</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Alumno
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" id="idMenuMantenedorAlumno" href="/schoolsystem/mantenedoralumnos.srv">Mantenedor de alumnos</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Profesores
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" id="idMenuMantenedorProfesores" href="#">Mantenedor de profesores</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            General
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" id="idMenuMantenedorCursos" href="#">Mantenedor de cursos</a>
                            <a class="dropdown-item" id="idMenuMantenedorAsignaturas" href="#">Mantenedor de asignaturas</a>
                        </div>
                        
                    </li>
                </ul>
            </div>
            <!-- <span class="navbar-text logOutData">
                Usuario Conectado
            </span>
            <span class="navbar-text">
                <form class="form-inline">
                    <button class="btn btn-outline-primary" type="button">
                        <span class="bi bi-arrow-bar-right" >
                    </button>
                </form>
            </span> -->
        </nav>
    </header>
    <br> <br>
 <div class="container mb-5 pb-3">
	<table class="table table-hover" id="tblListaAlumnos">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Curso</th>
      <th scope="col">Asignatura</th>
      <th scope="col">Modificar/Eliminar</th>
    </tr>
  </thead>
  <c:forEach items="${alumnos}" var="alumno">
		
		</c:forEach>
</table>
</div>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-dark" data-toggle="modal" data-target="#modalNuevoProfesor">Agregar Profesor</button>

	<!-- Modal -->
	<div class="modal fade" id="modalNuevoProfesor" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Nuevo Profesor</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="needs-validation" novalidate>
						<div class=form-row>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtNombre">Nombre</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtNombre" placeholder="Ingrese Nombre" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un nombre válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtApellido">Apellido</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtApellido" placeholder="Ingrese Apellido" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un apellido válido
					                    </div>
				                    </div>
				                </div>
				            </div>
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idTxtAsignatura">Asigntaura</label>
				                    <div class="form-inline">
				                        <input type="text" class="form-control" id="idTxtAsignatura" placeholder="Ingrese Asigntaura" required>
				                        <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar una asignatura válida
					                    </div>
				                    </div>
				                </div>
				            </div>
				         </div>
				         <div class="form-row">
				            <div class="col-md-4 mb-3">
				                <div class="form-group">
				                    <label for="idSelCurso">Curso</label>
				                    <select class="form-control" id="idSelCurso">
				                    	<option value="-1">-Seleccione Curso-</option>
				                    	<c:forEach var="curso" items="${cursoDto.cursos}">
				                    		<option value="<c:out value='${curso.idCurso}' />"><c:out value="${curso.descripcion}" /> </option>
				                    	</c:forEach>
				                    </select>
				                    <div class="valid-feedback">
                        					Correcto!
                    					</div>
					                    <div class="invalid-feedback">
					                        Debe ingresar un curso válido
					                    </div>
				                </div>
				            </div>
				         </div>
			    	</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id="idBtnGuardarProfesor">Guardar</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>