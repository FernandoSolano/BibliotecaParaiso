package com.bibliotecaParaiso.prestamos.domain;


public class Publicador {

	private int codigo;
	private String nombre;
	private String lugar;
	private String correo;
	
	public Publicador(int codigo, String nombre, String lugar, String correo){
		this.codigo = codigo;
		this.nombre = nombre;
		this.lugar = lugar;
		this.correo = correo;
	}

	public Publicador(){
		this.codigo = 0;
		this.nombre = "";
		this.lugar = "";
		this.correo = "";
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


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
