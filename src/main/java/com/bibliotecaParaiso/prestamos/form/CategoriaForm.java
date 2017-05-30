package com.bibliotecaParaiso.prestamos.form;

public class CategoriaForm {
	
	private int codigo;
	private String nombre;
	
	public CategoriaForm(){
		super();
		this.codigo = 0;
		this.nombre = "";
	}
	
	public CategoriaForm(int codigo){
		super();
		this.codigo = codigo;
		this.nombre = "";
	}
	
	public CategoriaForm(String nombre){
		super();
		this.codigo = 0;
		this.nombre = nombre;
	}
	
	public CategoriaForm(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
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
	
}
