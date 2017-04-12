package com.bibliotecaParaiso.prestamos.domain;

import java.util.LinkedList;

public class Libro {
	private int codigo;
	private String titulo, isbn, fecha_publicacion;
	private LinkedList<Categoria> categorias;
	private LinkedList<Autor> autores;
	private Publicador publicador;

	public Libro() {
		autores = new LinkedList<>();
		publicador = new Publicador();
		categorias = new LinkedList<>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public LinkedList<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(LinkedList<Categoria> categorias) {
		this.categorias = categorias;
	}

	public LinkedList<Autor> getAutores() {
		return autores;
	}

	public void setAutores(LinkedList<Autor> autores) {
		this.autores = autores;
	}

	public Publicador getPublicador() {
		return publicador;
	}

	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
}
