$(document).ready(function() {
	$('#idTblUsuarios').bootstrapTable({
		url: '',
		pagination: true,
		search: true,
		pageSize: 5,
		pageList: [5, 10, 15],
		locale: "es-ES",
		columns: [{
			field: 'nombre',
			title: 'Nombre',
			sortable: true,
			width: '200px'
		}, {
			field: 'email',
			title: 'Email',
			sortable: true,
			width: '400px'
		}
		]
	});

	$.ajax({
		type: "GET",
		url: "/ws/usuarios",
		dataType: "json",
		success: function(data) {
			//si todo sale bien, se agrega la funcionalidad
			//console.log(data);
			$('#idTblUsuarios').bootstrapTable('load', data.body);
		},
		error: function(dataError) {
			console.log(dataError);
		},
		async: true,
	});

});