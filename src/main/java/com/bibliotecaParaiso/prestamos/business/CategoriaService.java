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
import com.bibliotecaParaiso.prestamos.domain.Categoria;
import com.bibliotecaParaiso.prestamos.domain.Historial;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	public int insert(String nombre) {
		return this.categoriaDao.insert(nombre);
	}
	
	public List<Categoria> select() {
		return this.categoriaDao.select();
	}
	
	@Transactional
	public boolean actualizar(int codigo, String nombre){
		return this.categoriaDao.actualizar(codigo, nombre);
	}
	
	@Transactional
	public boolean borrar(int codigo) {
		return this.categoriaDao.borrar(codigo);
	}
	
}





