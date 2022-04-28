<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<title>Administraci�n Bodega</title>
</head>
<body>
	<!-- Navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="#">Home</a> <a
						class="nav-link" href="#">Features</a> <a class="nav-link"
						href="#">Pricing</a>
				</div>
			</div>
			<div class="text-end">
				<h6 class="text-light">
					Usuario Conectado:
					<c:out value="${user}"></c:out>
				</h6>
				<div>
					<form action="logout" method="get">
						<input type="submit" value="Desconectar">
					</form>
				</div>
			</div>
		</div>
	</nav>
	<!-- Main -->
	<main class="container my-5">

		<section class="my-5">
			<form action="#" method="get">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Precio</label> <input
						name="precio" type="number" class="form-control"
						id="exampleInputEmail1">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmpresa1" class="form-label">Nombre
						Material</label> <input name="nombre" type="text" class="form-control"
						id="exampleInputEmpresa1">
				</div>
				<div class="mb-3">
					<label for="exampleInputRut1" class="form-label">Nombre
						Bodega</label> <input name="bodega" type="text" class="form-control"
						id="exampleInputRut1">
				</div>
				<div align="right">
					<button type="submit" class="btn btn-primary btn-lg">Agregar</button>
				</div>
			</form>
		</section>
		<section class="my-5">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Precio</th>
						<th>Nombre</th>
						<th>Bodega</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${valores}" var="valor">
	<!-- 					<tr>
							<td><c:out value="${valor.algo}"></c:out></td>
						</tr> -->
					</c:forEach>
				</tbody>
			</table>
		</section>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>