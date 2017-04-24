package com.bibliotecaParaiso.prestamos.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecaParaiso.prestamos.data.HistorialDao;
import com.bibliotecaParaiso.prestamos.domain.Historial;

@Service
public class HistorialService {
	
	@Autowired
	private HistorialDao historialDao;
	
	public List<Historial> showAllHistory(int id){
		
		return historialDao.showAllHistory(id);
	}
	
	public List<Integer> numRegistros(){
		return historialDao.numRegistros();
	}
}
