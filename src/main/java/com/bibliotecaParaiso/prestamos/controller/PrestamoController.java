package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotecaParaiso.prestamos.business.PrestamoService;

@Controller
public class PrestamoController {
	@Autowired
	private PrestamoService prestamoService;
	
	@RequestMapping("/prestamo")
	public String iniciar(Model model){
		model.addAttribute("prestamo", prestamoService.solicitarPrestamo());
		return "prestamo";
	}
}
