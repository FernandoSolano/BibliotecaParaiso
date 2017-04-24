package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.PrestamoService;
import com.bibliotecaParaiso.prestamos.form.DevolucionForm;
import com.bibliotecaParaiso.prestamos.form.RenovacionForm;

@Controller
public class RenovacionController {
	@Autowired
	private PrestamoService prestamoService;
	
	@RequestMapping("/renovacion")
	public String iniciar(Model model, RenovacionForm renovacionForm){
		model.addAttribute("prestamos", prestamoService.listaPrestamos());
		return "renovacion";
	}
	
	@RequestMapping(value = "/renovacion", method=RequestMethod.POST)
	public String renovacion(Model model, RenovacionForm renovacionForm){
		model.addAttribute("prestamos",prestamoService.listaPrestamos());
		
		int codigoPrestamo = renovacionForm.getCodigoPrestamo();
		
		boolean resultado = prestamoService.renovacion(codigoPrestamo);
		
		if(resultado){
			model.addAttribute("mensaje", "Se ha realizado la renovación correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo renovar el préstamo");
		}
		
		return "renovacion";
	}
}