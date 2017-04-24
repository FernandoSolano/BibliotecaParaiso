package com.bibliotecaParaiso.prestamos.form;

public class DevolucionForm {
	
	private int codigo;
	
	public DevolucionForm(){
		this.codigo =0;
	}
	
	public DevolucionForm(int codigo) {
		super();
		this.codigo = codigo;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
}
