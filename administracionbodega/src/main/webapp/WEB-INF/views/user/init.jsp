<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/styles.css">
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
<title>Administración Bodega</title>
</head>
<body>
	<!-- Navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Administración Bodega</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown"
				aria-controls="navbarNavDarkDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDarkDropdownMenuLink1" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Materiales </a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><a class="dropdown-item" id="listarMateriales" href="#">Listar
									Materiales </a></li>
							<li><a class="dropdown-item" id="agregarMateriales" href="#"
								data-toggle="modal" data-target="#modalNuevoMaterial" onclick='listarBodegas()'>Agregar
									Materiales</a></li>
						</ul></li>
				</ul>
			</div>

			<div class="text-right row">
				<div class="text-light mr-4">
					<h4>Bienvenido:</h4>
					<c:out value="${user}"></c:out>
				</div>
				<div class="my-auto">
					<form action="logout" method="get">
						<input id="btnLogout" class="btn-primary" type="submit"
							value="Desconectar">
					</form>
				</div>
			</div>
		</div>
	</nav>

	<!-- Main -->
	<main class="container my-5">
		<table id="myTableBodega"></table>
		<table id="myTableMateriales"></table>
		<!-- Modal Agregar Producto-->
		<div class="modal fade" id="modalNuevoMaterial" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content  bg-dark">
					<div class="modal-header">
						<h5 class="modal-title text-light" id="exampleModalLongTitle">Nuevo
							Producto</h5>
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
										<label for="agregarMaterial">Nombre</label>
										<div class="form-inline">
											<input type="text" class="form-control" id="agregarMaterial"
												placeholder="Ingrese Nombre" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="agregarPrecio">Precio</label>
										<div class="form-inline">
											<input type="number" class="form-control" id="agregarPrecio"
												placeholder="Ingrese precio" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar precio
												válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="agregarFecha">Fecha ingreso</label>
										<div class="form-inline">
											<input type="date" class="form-control" id="agregarFecha"
												placeholder="Ingrese Fecha de ingreso" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una fecha
												válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="idSelBodega">Nombre Bodega</label>
										<div class="form-inline">
											<select class="form-control" id="idSelBodega">
												<option class="option1" value="-1">-Seleccione Bodega-</option>
											</select> 
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una bodega</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="button" class="btn btn-light"
							id="idBtnGuardarMaterial">Guardar</button>
					</div>
				</div>
			</div>
		</div>

		<!--modal editar producto -->
		<div class="modal fade" id="modalEditarMaterial" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content bg-dark">
					<div class="modal-header">
						<h5 class="modal-title text-light" id="exampleModalLongTitle">Editar
							Producto</h5>
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
										<label for="editarMateriales">Nombre</label>
										<div class="form-inline">
											<input type="text" class="form-control" id="editarMateriales"
												placeholder="" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="editarPrecio">Precio</label>
										<div class="form-inline">
											<input type="number" class="form-control" id="editarPrecio"
												placeholder="" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="editarFecha">Fecha</label>
										<div class="form-inline">
											<input type="date" class="form-control" id="editarFecha"
												placeholder="" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="idSelEditBodega">Nombre Bodega</label>
										<div class="form-inline">
											<select class="form-control" id="idSelEditBodega">
												<option class="option1" value="-1">-Seleccione Bodega-</option>
											</select> 
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una bodega</div>
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
							id="idBtnEditarMaterial">Guardar</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal Eliminar Producto-->
		<div class="modal fade" id="modalEliminarMaterial" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content bg-dark">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<h2 class="modal-body text-light">¿Está seguro de eliminar el
							producto?</h2>
						<input type="hidden" id="idEliminar" value="">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="button" class="btn btn-light"
							id=idBtnEliminarMaterial>Eliminar</button>
					</div>
				</div>
			</div>
		</div>

	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="../js/scriptBodega.js"></script>
	<script type="text/javascript" src="../js/scriptMateriales.js"></script>
</body>
</html>