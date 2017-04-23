package com.bibliotecaParaiso.prestamos.form;

public class PrestamoForm {
	
	private int codigoUsuario;
	private int codigoLibro;
	public PrestamoForm(int codigoUsuario, int codigoLibro) {
		super();
		this.codigoUsuario = codigoUsuario;
		this.codigoLibro = codigoLibro;
	}
	
	public PrestamoForm() {
		super();
		this.codigoUsuario = 0;
		this.codigoLibro = 0;
	}

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(int codigoLibro) {
		this.codigoLibro = codigoLibro;
	}
	
	
}
