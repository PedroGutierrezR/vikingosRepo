<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
    	let listaLibrosDto = '<%=request.getAttribute("listaLibros")%>';
</script>
<!-- CSS only -->
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
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Booklet</title>
</head>
<body>
	<!-- As a heading -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<span class="navbar-brand mb-0 h1">Booklet</span>
		</div>
	</nav>
	<main class="my-3">
		<section class="container">
			<table id="myTable" class="table table-hover">
			</table>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-dark my-3" data-toggle="modal"
				data-target="#modalNuevoLibro">Agregar Libro</button>
		</section>
		<section>
			<!-- Modal Agregar Libro-->
			<div class="modal fade" id="modalNuevoLibro" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalCenterTitle"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg"
					role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Nuevo
								Libro</h5>
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
											<label for="idTxtAgregarTitulo">Título</label>
											<div class="form-inline">
												<input type="text" class="form-control"
													id="idTxtAgregarTitulo" placeholder="Ingrese Título"
													required>
												<div class="valid-feedback">Correcto!</div>
												<div class="invalid-feedback">Debe ingresar una
													descripción válida</div>
											</div>
										</div>
									</div>
									<div class="col-md-4 mb-3">
										<div class="form-group">
											<label for="idTxtAgregarAnio">Año</label>
											<div class="form-inline">
												<input type="number" class="form-control"
													id="idTxtAgregarAnio" placeholder="Ingrese Año" required>
												<div class="valid-feedback">Correcto!</div>
												<div class="invalid-feedback">Debe ingresar una
													descripción válida</div>
											</div>
										</div>
									</div>
									<div class="col-md-4 mb-3">
										<div class="form-group">
											<label for="idTxtAgregarAutor">Autor</label>
											<div class="form-inline">
												<input type="text" class="form-control"
													id="idTxtAgregarAutor" placeholder="Ingrese Autor" required>
												<div class="valid-feedback">Correcto!</div>
												<div class="invalid-feedback">Debe ingresar una
													descripción válida</div>
											</div>
										</div>
									</div>
									<div class="col-md-4 mb-3">
										<div class="form-group">
											<label for="idTxtAgregarImprenta">Imprenta</label>
											<div class="form-inline">
												<input type="text" class="form-control"
													id="idTxtAgregarImprenta" placeholder="Ingrese Imprenta"
													required>
												<div class="valid-feedback">Correcto!</div>
												<div class="invalid-feedback">Debe ingresar una
													descripción válida</div>
											</div>
										</div>
									</div>
									<div class="col-md-4 mb-3">
										<div class="form-group">
											<label for="idTxtAgregarDisponibilidad">Disponibilidad</label>
											<div class="form-inline">
												<input type="text" class="form-control"
													id="idTxtAgregarDisponibilidad"
													placeholder="Ingrese Disponibilidad" required>
												<div class="valid-feedback">Correcto!</div>
												<div class="invalid-feedback">Debe ingresar una
													descripción válida</div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cerrar</button>
							<button type="button" class="btn btn-primary"
								id="idBtnGuardarLibro">Guardar</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
		<!-- Modal Eliminar Libro-->
	<div class="modal fade" id="modalEliminarLibro" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
					<h2>¿Está seguro de eliminar el libro?</h2>
					<input type="hidden" id="idEliminar" value="">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id=idBtnEliminarLibro>Eliminar</button>
				</div>
			</div>
		</div>
	</div>
	

	<script type="text/javascript" src="../js/script.js"></script>
</body>
</html>