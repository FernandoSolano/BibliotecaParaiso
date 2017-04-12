package com.bibliotecaParaiso.prestamos.domain;

import java.util.List;

public class Autor {
private int codigo;
private String nombre;
private String apellidos;
private String pseudonimo;

public Autor(){
	
	
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

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public String getPseudonimo() {
	return pseudonimo;
}

public void setPseudonimo(String pseudonimo) {
	this.pseudonimo = pseudonimo;
}


}
