package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotecaParaiso.prestamos.business.HistorialService;

@Controller
public class HistorialController {
	@Autowired
	private HistorialService historialService;
	
	@RequestMapping("/historial")
	public String iniciar(Model model){
		model.addAttribute("historial", historialService.showAllHistory());
		return "historial";
	}
}
