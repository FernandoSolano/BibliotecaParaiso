package com.bibliotecaParaiso.prestamos.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecaParaiso.prestamos.data.PrestamoDao;
import com.bibliotecaParaiso.prestamos.domain.Historial;
import com.bibliotecaParaiso.prestamos.domain.Libro;
import com.bibliotecaParaiso.prestamos.domain.Prestamo;
import com.bibliotecaParaiso.prestamos.domain.Usuario;

@Service
public class PrestamoService {
	
	@Autowired
	private PrestamoDao prestamoDao;
	
	public boolean solicitarPrestamo(){
		return prestamoDao.solicitarPrestamo();
	}
	
	public List<Usuario> listaUsuarios(){
		return prestamoDao.listaUsuarios();
	}
	
	public List<Libro> listaLibros(){
		return prestamoDao.listaLibros();
	}
	
}
