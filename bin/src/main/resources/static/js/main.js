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
	
	$('#btnHome').on('click', function(){
		window.location = '/';
	});
	
});