<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Contact Manager</title>
</head>
<body>
	<!-- As a heading -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Contact Manager</span>
		</div>
	</nav>
	<main class="my-5">
		<section class="container">
			<form:form class="row" action="/contactManager/addContact"
				method="POST" modelAttribute="contacto">
				<div class="mb-3 col-4">
					<label for="idNombre" class="form-label">Nombre</label>
					<form:input path="nombre" type="text" class="form-control"
						id="idNombre"/>
				</div>
				<div class="mb-3 col-4">
					<label for="idApellidoPaterno" class="form-label">Apellido
						paterno</label>
					<form:input path="apellidoPaterno" type="text" class="form-control"
						id="idApellidoPaterno" />
				</div>
				<div class="mb-3 col-4">
					<label for="idApellidoMaterno" class="form-label">Apellido
						Materno</label>
					<form:input path="apellidoMaterno" type="text" class="form-control"
						id="idApellidoMaterno" />
				</div>
				<div class="mb-3 col-6">
					<label for="direccion" class="form-label">Dirección</label>
					<form:input path="direccion" type="text" class="form-control"
						id="direccion" />
				</div>
				<div class="mb-3 col-6">
					<label for="idTelefono" class="form-label">Teléfono</label>
					<form:input path="telefono" type="number" class="form-control"
						id="idTelefono" />
				</div>
				<div class="mb-3">
					<button type="submit" class="btn btn-primary my-4">Agregar
						Contacto</button>
				</div>
			</form:form>
		</section>
		<section class="container my-5">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Apellido Paterno</th>
						<th>Apellido Materno</th>
						<th>Dirección</th>
						<th>Teléfono</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listaContactos}" var="contacto">
						<form:form action="/contactManager/deleteContact" method="POST"
							modelAttribute="contacto">
							<tr>
								<td><form:input path="idContacto" type="hidden"
										value="${contacto.idContacto}" /> <c:out
										value="${contacto.idContacto}"></c:out></td>
								<td><c:out value="${contacto.nombre}"></c:out></td>
								<td><c:out value="${contacto.apellidoPaterno}"></c:out></td>
								<td><c:out value="${contacto.apellidoMaterno}"></c:out></td>
								<td><c:out value="${contacto.direccion}"></c:out></td>
								<td><c:out value="${contacto.telefono}"></c:out></td>
								<td><button type="submit" class="btn btn-primary">Eliminar</button></td>
							</tr>
						</form:form>
					</c:forEach>

				</tbody>
			</table>
		</section>
	</main>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>