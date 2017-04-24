package com.bibliotecaParaiso.prestamos.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.PrestamoService;
import com.bibliotecaParaiso.prestamos.domain.Prestamo;
import com.bibliotecaParaiso.prestamos.form.PrestamoForm;

@Controller
public class PrestamoController {
	@Autowired
	private PrestamoService prestamoService;
	
	
	public PrestamoController(PrestamoService prestamoService) {
		super();
		this.prestamoService = prestamoService;
	}

	@RequestMapping("/prestamo")
	public String iniciar(Model model, PrestamoForm prestamoForm){
		model.addAttribute("usuarios", prestamoService.listaUsuarios());
		model.addAttribute("libros", prestamoService.listaLibros());
		
		return "prestamo";
	}
	
	@RequestMapping(value = "/prestamo", method=RequestMethod.POST)
	public String prestamo(Model model, PrestamoForm prestamoForm){
		model.addAttribute("usuarios", prestamoService.listaUsuarios());
		model.addAttribute("libros", prestamoService.listaLibros());
		
		Prestamo prestamo = new Prestamo();
		prestamo.getUsuario().setCodigoUsuario(prestamoForm.getCodigoUsuario());
		prestamo.getLibro().setCodigo(prestamoForm.getCodigoLibro());
		
		try {
			prestamo = prestamoService.insertarPrestamo(prestamo);
			
			if(prestamo.getCodigo() == 0){
				model.addAttribute("mensaje", "No se pudo crear el prestamo");
			}else{
				model.addAttribute("mensaje", "Prestamo creado con exito");
				model.addAttribute("librosRecomendados", prestamoService.getRecomendaciones(prestamoForm.getCodigoUsuario()));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("mensaje", "No se pudo crear el prestamo CATCH");
		}
		
		return "prestamo";
	}
	
	
}
