<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
	integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form class="row" action="/contactManager/addContact"
		method="POST" modelAttribute="contacto">

		<div class="container my-5 text-center">
			<h4>Contact Manager</h4>
		</div>
		<div class="container my-5">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label for="idNombre" class="input-group-text">Nombre</label>
				</div>
				<form:input path="nombre" id="idNombre" type="text"
					class="form-control" placeholder="nombre" aria-label="nombre"
					aria-describedby="basic-addon1" />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label for="idApellidoPaterno" class="input-group-text">Apellido Paterno</label>
				</div>
				<form:input path="apellidoPaterno" id="idApellidoPaterno"
					type="text" class="form-control" placeholder="apellido paterno"
					aria-label="apellidoPaterno" aria-describedby="basic-addon1" />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label for="idApellidoMaterno" class="input-group-text">Apellido Materno</label>
				</div>
				<form:input path="apellidoMaterno" id="idApellidoMaterno"
					type="text" class="form-control" placeholder="apellido materno"
					aria-label="apellidoMaterno" aria-describedby="basic-addon1" />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label for="idDireccion" class="input-group-text">Dirección</label>
				</div>
				<form:input path="direccion" id="idDireccion" type="text"
					class="form-control" placeholder="direccion" aria-label="direccion"
					aria-describedby="basic-addon1" />
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<label for="idTelefono" class="input-group-text">Teléfono</label>
				</div>
				<form:input path="telefono" id="idTelefono" type="text"
					class="form-control" placeholder="telefono" aria-label="telefono"
					aria-describedby="basic-addon1" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary my-4">Agregar</button>
			</div>

		</div>
	</form:form>
	<div class="container mb-5">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido Paterno</th>
						<th scope="col">Apellido Materno</th>
						<th scope="col">Dirección</th>
						<th scope="col">Teléfono</th>
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
		</div>
</body>
</html>