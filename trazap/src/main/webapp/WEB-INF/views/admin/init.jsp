<%@ page language="java" contentType="text/html;"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="../assets/css/cssadmin/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/css/cssadmin/font-awesome.min.css">
<link rel="stylesheet" href="../assets/css/cssadmin/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="../assets/css/cssadmin/tooplate-gymso-style.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
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
					<li class="nav-item"><a href="#home"
						class="nav-link smoothScroll">Home</a></li>

					<li class="nav-item"><a href="#about"
						class="nav-link smoothScroll">Productos</a></li>

					<li class="nav-item"><a href="#class"
						class="nav-link smoothScroll">Proveedor</a></li>

					<li class="nav-item"><a href="#contact"
						class="nav-link smoothScroll">Trazabilidad</a></li>
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

						<a href="#about" class="btn custom-btn bordered mt-3"
							data-aos="fade-up" data-aos-delay="700">Comencemos</a>

					</div>
				</div>

			</div>
		</div>
	</section>


	<section class="feature" id="feature">
		<div class="container">
			<h2 class="mb-3 text-white" data-aos="fade-up">Área de
				administración</h2>
		</div>
	</section>


	<!-- ABOUT -->
	<section class="about section" id="about">
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
				onClick="getTipoProducto();getCategoria();">Agregar
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
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
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
										<div class="invalid-feedback">Debe ingresar un curso
											válido</div>
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
	</section>


	<!-- CLASS -->
	<section class="class section" id="class">
		<div class="container">
			<div class="row">

				<div class="col-lg-12 col-12 text-center mb-5">
					<h6 data-aos="fade-up">Administra:</h6>
					<h2 data-aos="fade-up" data-aos-delay="200">Proveedores</h2>
					<div class="container">
						<table class="table table-hover" id="idTablaProveedor">
						</table>
						<button type="button" id="idBtnAgregarProveedor"
							class="btn btn-outline-danger btn-lg">Agregar Proveedor</button>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- CONTACT -->
	<section class="contact section" id="contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-12 text-center mb-5">
					<h2 class="mb-4 pb-2" data-aos="fade-up">Trazabilidad</h2>
					<div class="container">
						<table class="table table-hover" id="idTablaTrazabilidad">
						</table>
						<button type="button" id="idBtnAgregarTrazabilidad"
							class="btn btn-outline-danger btn-lg">Agregar
							Trazabilidad</button>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- FOOTER -->
	<footer class="site-footer">
		<div class="container">
			<div class="row">

				<div class="ml-auto col-lg-4 col-md-5">
					<p class="copyright-text">Copyright &copy; 2022 Trazap</p>
				</div>

				<div
					class="d-flex justify-content-center mx-auto col-lg-5 col-md-7 col-12">
					<p class="mr-4">
						<i class="fa fa-envelope-o mr-1"></i> <a href="#">vikingos@trazap.com</a>
					</p>

					<p>
						<i class="fa fa-phone mr-1"></i> 010-020-0840
					</p>
				</div>

			</div>
		</div>
	</footer>

	<!-- Modal -->
	<div class="modal fade" id="membershipForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Membership
						Form</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" role="form">
						<input type="text" class="form-control" name="cf-name"
							placeholder="John Doe"> <input type="email"
							class="form-control" name="cf-email"
							placeholder="Johndoe@gmail.com"> <input type="tel"
							class="form-control" name="cf-phone" placeholder="123-456-7890"
							pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required>

						<textarea class="form-control" rows="3" name="cf-message"
							placeholder="Additional Message"></textarea>

						<button type="submit" class="form-control" id="submit-button"
							name="submit">Submit Button</button>

						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="signup-agree"> <label
								class="custom-control-label text-small text-muted"
								for="signup-agree">I agree to the <a href="#">Terms
									&amp;Conditions</a>
							</label>
						</div>
					</form>
				</div>

				<div class="modal-footer"></div>

			</div>
		</div>
	</div>

	<!-- SCRIPTS -->
	<script src="../assets/js/jsadmin/aos.js"></script>
	<script src="../assets/js/jsadmin/smoothscroll.js"></script>
	<script src="../assets/js/jsadmin/custom.js"></script>
	<script type="text/javascript" src="../assets/js/producto.js"></script>
	<script type="text/javascript" src="../assets/js/proveedor.js"></script>
	<script type="text/javascript" src="../assets/js/trazabilidad.js"></script>
</body>
</html>