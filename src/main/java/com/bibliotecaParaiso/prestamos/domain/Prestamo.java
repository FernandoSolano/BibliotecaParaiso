package com.bibliotecaParaiso.prestamos.domain;

import java.sql.Date;

public class Prestamo {

	private int codigo;
	private Usuario usuario;
	private Libro libro;
	private String fechaPrestamo;
	private String fechaLimite;
	
	public Prestamo(){
		this.usuario = new Usuario();
		this.libro = new Libro();
		this.codigo = 0;
	}

	public Prestamo(int codigo, String fecha_prestamo, String nombre, String titulo) {
		this.usuario = new Usuario();
		this.libro = new Libro();
		this.codigo = codigo;
		this.fechaPrestamo = fecha_prestamo;
		this.usuario.setNombre(nombre);
		this.libro.setTitulo(titulo);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	
	
	
}
