<%@page import="cl.desafiolatam.schoolsystem.dto.CursoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script>
    	let asignaturaDtoJson = '<%=request.getAttribute("asignaturaDtoJson")%>';
</script>

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
<script src="assets/js/mantenedoraasignaturas.js"></script>

<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover" id="tblListaAsignaturas">
	</table>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-dark" data-toggle="modal"
		data-target="#modalNuevaAsignatura">Agregar Asignatura</button>

	<!-- Modal Agregar Tipo Asignatura-->
	<div class="modal fade" id="modalNuevaAsignatura" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Nueva Asignatura</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="needs-validation" novalidate>
						<div class=form-row>
							<div class="col-md-6 mb-3">
								<div class="form-group">
									<label for="idTxtDescripcionAsignatura">Descripción</label>
									<div class="form-inline">
										<input type="text" class="form-control" id="idTxtDescripcionAsignatura"
											placeholder="Ingrese Descripcion" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar una
											descripción válida</div>
									</div>
								</div>
							</div>
							<div class="form-row">
				            <div class="col-md-6 mb-3">
				                <div class="form-group">
				                    <label for="idSelAgregarAsignatura">Tipo</label>
				                    <div class="form-inline">
				                    <select class="form-control" id="idSelAgregarAsignatura">
				                    	<option value="-1">-Seleccione Tipo-</option>
				                    	<c:forEach var="tipoAsignatura" items="${tipoAsignaturaDto.tipoAsignaturas}">
				                    		<option value="<c:out value='${tipoAsignatura.idTipoAsignatura}' />"><c:out value="${tipoAsignatura.descripcion}" /> </option>
				                    	</c:forEach>
				                    </select>
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
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary"
						id="idBtnGuardarAsignatura">Guardar</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Editar Tipo Asignatura-->
	<div class="modal fade" id="modalEditarCurso" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-lg"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Editar Descripción</h5>
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
									<label for="idTxtActualizarDescripcion">Descripcion</label>
									<div class="form-inline">
										<input type="text" class="form-control" id="idTxtActualizarDescripcion"
											placeholder="Ingrese Descripcion" required>
										<div class="valid-feedback">Correcto!</div>
										<div class="invalid-feedback">Debe ingresar un número</div>
									</div>
								</div>
							</div>
				            <div class="col-md-6 mb-3">
				                <div class="form-group">
				                    <label for="idSelActualizarAsignatura">Tipo</label>
				                    <div class="form-inline">
				                    <select class="form-control" id="idSelActualizarAsignatura">
				                    	<option value="-1">-Seleccione Tipo-</option>
				                    	<c:forEach var="tipoAsignatura" items="${tipoAsignaturaDto.tipoAsignaturas}">
				                    		<option value="<c:out value='${tipoAsignatura.idTipoAsignatura}' />"><c:out value="${tipoAsignatura.descripcion}" /> </option>
				                    	</c:forEach>
				                    </select>
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
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary"
						id="idBtnActualizarAsignatura">Guardar</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>