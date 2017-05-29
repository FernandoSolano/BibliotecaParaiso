package com.bibliotecaParaiso.prestamos.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecaParaiso.prestamos.data.CategoriaDao;
import com.bibliotecaParaiso.prestamos.data.HistorialDao;
import com.bibliotecaParaiso.prestamos.domain.Historial;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	public int insert(String nombre) {
		return this.categoriaDao.insert(nombre);
	}
}
