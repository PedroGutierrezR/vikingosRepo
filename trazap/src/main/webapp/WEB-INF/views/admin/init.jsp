<%@ page language="java" contentType="text/html;"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Trazap - Admin</title>


<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">


<link rel="stylesheet" href="../assets/css/cssadmin/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/css/cssadmin/font-awesome.min.css">
<link rel="stylesheet" href="../assets/css/cssadmin/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="../assets/css/cssadmin/tooplate-gymso-style.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body data-spy="scroll" data-target="#navbarNav" data-offset="50">

	<!-- MENU BAR -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">

			<a class="navbar-brand" href="#">Trazap</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-lg-auto">

					<li class="nav-item"><a href="#productos" title="click para ver productos" 
						class="nav-link smoothScroll" id="listarProductos">Productos</a></li>

					<li class="nav-item"><a href="#trazabilidad" title="click para ver trazabilidad" 
						class="nav-link smoothScroll" id="listarTrazabilidad">Trazabilidad</a></li>
				</ul>
			</div>
			<div class="ms-5">
				<form action="/logout" method="get">
					<input style="border-radius: 8px;" id="btnLogout"
						class="btn-white px-3 py-1" type="submit" value="salir">
				</form>
			</div>
		</div>
	</nav>


	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">
			<div class="row">

				<div class="col-lg-8 col-md-10 mx-auto col-12">
					<div class="hero-text mt-5 text-center">

						<h6 data-aos="fade-up" data-aos-delay="300">Bienvenidos a:</h6>

						<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">Trazap
							- Vikingos</h1>

					</div>
				</div>

			</div>
		</div>
	</section>

	<!-- PRODUCTOS -->
	<section class="about section sectionProducto" id="productos">
		<div class="container">
			<div class="row">
				<h2 class="mb-3 text-dark" data-aos="fade-up">Productos</h2>
		<div class="container">
					<table class="table table-hover" id="idTablaProductos">
					</table>
				</div>
			</div>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-danger" data-bs-toggle="modal"
				data-bs-target="#modalAgregarProducto"
				onClick="getTipoProducto(option1);getCategoria(option2);">Agregar
				Producto</button>
		</div>
		<!-- Modal Agregar Producto-->
		<!-- Modal -->
		<div class="modal fade" id="modalAgregarProducto" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Nuevo Producto</h5>
						<button type="button" class="btn-close mb-3"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form class="needs-validation" novalidate>
							<div class=form-row>
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarDescripcion">Descripción</label>
										<div class="form-inline">
											<input type="text" class="form-control"
												id="idTxtAgregarDescripcion"
												placeholder="Ingrese Descripción" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idSelTipoProducto">Tipo</label> <select
											class="form-control" id="idSelTipoProducto">
											<option id="option1" value="-1">-Seleccione Tipo-</option>
										</select>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idSelCategoriaProducto">Categoria</label> <select
											class="form-control" id="idSelCategoriaProducto">
											<option id="option2" value="-1">-Seleccione
												Categoria-</option>
										</select>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cerrar</button>
						<button id="idBtnGuardarProducto" type="button"
							class="btn btn-danger">Guardar</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal Eliminar Producto-->
		<div class="modal fade" id="modalEliminarProducto" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content bg-dark">
					<div class="modal-header">
						<button type="button" class="close"
							onclick="$('#modalEliminarProducto').modal('hide');"
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
							onclick="$('#modalEliminarProducto').modal('hide');">Cerrar</button>
						<button type="button" class="btn btn-light"
							id=idBtnEliminarProducto>Eliminar</button>
					</div>
				</div>
			</div>
		</div>

		<!--modal editar producto -->
		<div class="modal fade" id="modalEditarProducto" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Editar
							Producto</h5>
						<button type="button" class="close" onclick="$('#modalEditarProducto').modal('hide');"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="needs-validation" novalidate>
							<div class=form-row>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="idTxtEditarDescripcionProducto">Nombre</label>
										<div class="form-inline">
											<input type="text" class="form-control"
												id="idTxtEditarDescripcionProducto" placeholder="" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idSelEditarTipoProducto">Tipo</label> <select
											class="form-control" id="idSelEditarTipoProducto">
											<option id="editarOption1" value="-1">-Seleccione Tipo-</option>
										</select>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idSelEditarCategoriaProducto">Categoria</label> <select
											class="form-control" id="idSelEditarCategoriaProducto">
											<option id="editarOption2" value="-1">-Seleccione
												Categoria-</option>
										</select>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							onclick="$('#modalEditarProducto').modal('hide');">Cerrar</button>
						<button type="button" class="btn btn-primary"
							id="idBtnEditarProducto">Guardar</button>
					</div>
				</div>
			</div>
		</div>

	</section>

	<!-- TRAZABILIDAD -->
	<section class="contact section sectiontrazabilidad" id="trazabilidad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-12 text-start mb-5">
					<h2 class="mb-4 pb-2" data-aos="fade-up">Trazabilidad</h2>
					<div class="container">
						<table class="table table-hover" id="idTablaTrazabilidad">
						</table>
						<button type="button" id="idBtnGuardarTrazabilidad"
							class="btn btn-outline-danger btn-lg" data-bs-target="#modalNuevaTrazabilidad"
							data-bs-toggle="modal">Agregar
							Trazabilidad</button>
					</div>
				</div>
			</div>
		</div>					
					
		<!-- Modal Agregar Producto-->
		<!-- Modal -->
		<div class="modal fade" id="modalNuevaTrazabilidad" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Nueva trazabilidad</h5>
						<button type="button" class="btn-close mb-3"
							data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form class="needs-validation" novalidate>
							<div class=form-row>
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarFechaInicioPreparacion">Fecha inicio</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtAgregarFechaInicioPreparacion"
												placeholder="Ingrese fecha" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarFechaFinPreparacion">Fecha final</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtAgregarFechaFinPreparacion"
												placeholder="Ingrese fecha" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarFechaEstimadaEnvio"">Fecha estimada</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtAgregarFechaEstimadaEnvio"
												placeholder="Ingrese fecha" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
								</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarFechaEnvio">Fecha envio</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtAgregarFechaEnvio"
												placeholder="Ingrese fecha" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
								</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarCodigoTrazabilidad">codigo trazabilidad</label>
										<div class="form-inline">
											<input type="text" class="form-control"
												id="idTxtAgregarCodigoTrazabilidad"
												placeholder="Ingrese codigo" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
								</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarPedido">pedido</label>
										<div class="form-inline">
											<input type="number" class="form-control"
												id="idTxtAgregarPedido"
												placeholder="Ingrese datos" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
								</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtAgregarEstadoTrazabilidad">Estado trazabilidad</label>
										<div class="form-inline">
											<input type="number" class="form-control"
												id="idTxtAgregarEstadoTrazabilidad"
												placeholder="Ingrese estado" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
									</div>
								</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Cerrar</button>
						<button id="idBtnAgregarTrazabilidad" type="button"
							class="btn btn-danger">Guardar</button>
					</div>
				</div>
			</div>
		</div>
		<!--modal editar producto -->
		<div class="modal fade" id="modalEditarTrazabilidad" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Editar
							Trazabilidad</h5>
						<button type="button" class="close" onclick="$('#modalEditarTrazabilidad').modal('hide');"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="needs-validation" novalidate>
							<div class=form-row>
								<div class="col-md-4 mb-3">
									<div class="form-group">
										<label for="idTxtEditarFechaInicioPreparacion">Fecha Inicio</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtEditarFechaInicioPreparacion" placeholder="" required>
											<div class="valid-feedback">Correcto!</div>
											<div class="invalid-feedback">Debe ingresar una
												descripción válida</div>
										</div>
									</div>
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtEditarFechaFinPreparacion">Fecha final</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtEditarFechaFinPreparacion" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtEditartFechaEstimadaEnvio">Fecha estimada</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtEditartFechaEstimadaEnvio" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtEditarFechaEnvio">Fecha envio</label>
										<div class="form-inline">
											<input type="date" class="form-control"
												id="idTxtEditarFechaEnvio" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtEditarCodigoTrazabilidad">Codigo</label>
										<div class="form-inline">
											<input type="text" class="form-control"
												id="idTxtEditarCodigoTrazabilidad" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="#idTxtEditarPedido">Pedido</label>
										<div class="form-inline">
											<input type="number" class="form-control"
												id="#idTxtEditarPedido" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="idTxtEditarEstadoTrazabilidad">Estado Trazabilidad</label>
										<div class="form-inline">
											<input type="number" class="form-control"
												id="idTxtEditarEstadoTrazabilidad" placeholder="" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una descripción	válida</div>
									</div>
								</div>
							</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							onclick="$('#modalEditarTrazabilidad').modal('hide');">Cerrar</button>
						<button type="button" class="btn btn-primary"
							id="idBtnEditarTrazabilidad">Guardar</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal Eliminar Producto-->
		<div class="modal fade" id="modalEliminarTrazabilidad" tabindex="-1"
			role="dialog" aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered modal-lg"
				role="document">
				<div class="modal-content bg-dark">
					<div class="modal-header">
						<button type="button" class="close"
							onclick="$('#modalEliminarTrazabilidad').modal('hide');"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<h2 class="modal-body text-light">¿Está seguro de eliminar la
							trazabilidad?</h2>
						<input type="hidden" id="idEliminar" value="">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							onclick="$('#modalEliminarTrazabilidad').modal('hide');">Cerrar</button>
						<button type="button" class="btn btn-light"
							id=idBtnEliminarTrazabilidad>Eliminar</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	


	<!-- SCRIPTS -->
	<script src="../assets/js/jsadmin/aos.js"></script>
	<script src="../assets/js/jsadmin/smoothscroll.js"></script>
	<script src="../assets/js/jsadmin/custom.js"></script>
	<script type="text/javascript" src="../assets/js/producto.js"></script>
	<script type="text/javascript" src="../assets/js/proveedor.js"></script>
	<script type="text/javascript" src="../assets/js/trazabilidad.js"></script>
</body>
</html>