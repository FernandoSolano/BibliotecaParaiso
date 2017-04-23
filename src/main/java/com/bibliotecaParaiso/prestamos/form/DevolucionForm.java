package com.bibliotecaParaiso.prestamos.form;

public class DevolucionForm {
	
	private int codigo;
	private String nombre;
	private String titulo;
	private String fecha_prestamo;
	public DevolucionForm(int codigo, String nombre, String titulo, String fecha_prestamo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.titulo = titulo;
		this.fecha_prestamo = fecha_prestamo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(String fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	
	
}
