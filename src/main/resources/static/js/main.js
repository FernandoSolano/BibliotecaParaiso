$(document).ready(function(){
	$('#btnPrestamo').on('click', function(){
		window.location = '/prestamo';
	});
	
	$('#btnHistorial').on('click', function(){
		window.location = '/historial';
	});
	
	$('#btnRenovacion').on('click', function(){
		window.location = '/renovacion';
	});
	
	$('#btnDevolucion').on('click', function(){
		window.location = '/devolucion';
	});
	
	$('#btnCategoria').on('click', function(){
		window.location = '/categoria';
	});
		
		$('#btnCategoriaInsertar').on('click', function(){
			window.location = '/categoria/insertar';
		});
	
		$('#btnCategoriaActualizar').on('click', function(){
			window.location = '/categoria/actualizar';
		});
		
		$('#btnCategoriaVer').on('click', function(){
			window.location = '/categoria/ver';
		});
		
		$('#btnCategoriaBorrar').on('click', function(){
			window.location = '/categoria/borrar';
		});
	
	
	$('#btnPublicador').on('click', function(){
		window.location = '/publicador';
	});
	
		$('#btnPublicadorInsertar').on('click', function(){
			window.location = '/publicador/insertar';
		});
	
		$('#btnPublicadorActualizar').on('click', function(){
			window.location = '/publicador/actualizar';
		});
		
		$('#btnPublicadorVer').on('click', function(){
			window.location = '/publicador/ver';
		});
		
		$('#btnPublicadorBorrar').on('click', function(){
			window.location = '/publicador/borrar';
		});
	
	$('#btnHome').on('click', function(){
		window.location = '/';
	});
	
});