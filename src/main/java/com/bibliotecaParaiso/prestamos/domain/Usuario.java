package com.bibliotecaParaiso.prestamos.domain;

public class Usuario {
	private int codigoUsuario;
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public Usuario(){
		
	}
	
	public Usuario(int codigoUsuario, String cedula){
		this.codigoUsuario = codigoUsuario;
		this.cedula = cedula;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
