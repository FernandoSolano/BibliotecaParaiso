$(document).ready(function(){
	$('#btnPrestamo').on('click', function(){
		window.location = '/prestamo';
	});
	
	$('#btnHistorial').on('click', function(){
		window.location = '/historial';
	});
	
	$('#btnHome').on('click', function(){
		window.location = '/';
	});
});