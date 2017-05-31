package com.bibliotecaParaiso.prestamos.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecaParaiso.prestamos.data.CategoriaDao;
import com.bibliotecaParaiso.prestamos.data.HistorialDao;
import com.bibliotecaParaiso.prestamos.data.PublicadorDao;
import com.bibliotecaParaiso.prestamos.domain.Categoria;
import com.bibliotecaParaiso.prestamos.domain.Historial;
import com.bibliotecaParaiso.prestamos.domain.Publicador;

@Service
public class PublicadorService {
	
	@Autowired
	private PublicadorDao publicadorDao;
	
	public int insert(String nombre, String lugar, String correo) {
		return this.publicadorDao.insert(nombre, lugar, correo);
	}
	
	public List<Publicador> select() {
		return this.publicadorDao.select();
	}
	
	@Transactional
	public boolean actualizar(int codigo, String nombre, String lugar, String correo){
		return this.publicadorDao.actualizar(codigo, nombre, lugar, correo);
	}
	
	@Transactional
	public boolean borrar(int codigo) {
		return this.publicadorDao.borrar(codigo);
	}
	
}





