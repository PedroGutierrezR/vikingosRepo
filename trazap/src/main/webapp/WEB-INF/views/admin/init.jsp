<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trazap Administrador</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />

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

<script>
	$(document).ready(function() {
		$('#idTblUsuarios').bootstrapTable({
			url : '',
			pagination : true,
			search : true,
			pageSize : 5,
			pageList : [ 5, 10, 15 ],
			locale : "es-ES",
			columns : [ {
				field : 'nombre',
				title : 'Nombre',
				sortable : true,
				width : '200px'
			}, {
				field : 'email',
				title : 'Email',
				sortable : true,
				width : '400px'
			} ]
		});

		$.ajax({
			type : "GET",
			url : "/ws/usuarios",
			dataType : "json",
			success : function(data) {
				//si todo sale bien, se agrega la funcionalidad
				//console.log(data);
				$('#idTblUsuarios').bootstrapTable('load', data.body);
			},
			error : function(dataError) {
				console.log(dataError);
			},
			async : true,
		});

		/*$('#idBtnBuscarPokemones').click(function(){
		    $.ajax({
		        type:"GET",
		        url:"https://pokeapi.co/api/v2/pokemon?offset=200&limit=200",
		        dataType:"json",
		        success: function(data) {
		            $('#idTblPokeApi').bootstrapTable('load', data.results);
		        },
		        error: function(dataError) {
		            console.log(dataError);
		        },
		        async: true,
		    });

		    console.log("Termino");
		});
		 */

	});
</script>
</head>
<body style="background-color: #F0F8FF;">

	<header class="col-lg-12"
		style="background-color: #B0C4DE; padding-top: 20px; padding-bottom: 20px;">
		<h1 class="text-center fw-bold"
			style="color: #F8F8FF; font-size: 50px;">Bienvenido a TRAZAP</h1>
		<div class="container text-center text-primary">
			<h4>Usted ha ingresado como administrador</h4>
		</div>
	</header>
	<div class="container">
		<div class="col-lg-12" style="padding-top: 30px;">
			<form action="/logout" method="get">
				<table class="table table-hover" id="idTblUsuarios"
					name="tblUsuarios" style="background-color: #FFFFFF;">
				</table>
				<button type="submit"
					class="btn btn-primary mb-4 float-right shadow-sm"
					style="margin-left: 5px;">Salir</button>
				<button type="submit"
					class="btn btn-primary mb-4 float-right shadow-sm"
					id="idBtnAgregarUsuario">Agregar Usuario</button>
			</form>
		</div>
	</div>
</body>
</html>