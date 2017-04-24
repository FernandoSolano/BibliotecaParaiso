package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.HistorialService;

@Controller
public class HistorialController {
	@Autowired
	private HistorialService historialService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/historial")
	public String redirigir(){
		return "redirect:/historial/1";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/historial/{id}")
	public String iniciar(Model model, @PathVariable int id){
		model.addAttribute("historial", historialService.showAllHistory(id));
		model.addAttribute("numRegistros", historialService.numRegistros());
		return "historial";
	}
}
