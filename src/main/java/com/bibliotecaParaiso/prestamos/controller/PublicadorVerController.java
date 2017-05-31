package com.bibliotecaParaiso.prestamos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.CategoriaService;
import com.bibliotecaParaiso.prestamos.business.PrestamoService;
import com.bibliotecaParaiso.prestamos.business.PublicadorService;
import com.bibliotecaParaiso.prestamos.form.CategoriaForm;
import com.bibliotecaParaiso.prestamos.form.PrestamoForm;

@Controller
public class PublicadorVerController {
	@Autowired
	private PublicadorService publicadorService;
	
	public PublicadorVerController(PublicadorService publicadorService) {
		super();
		this.publicadorService = publicadorService;
	}
	
	@RequestMapping("/publicador/ver")
	public String iniciar(Model model, CategoriaForm categoriaForm){
		model.addAttribute("publicadores", this.publicadorService.select());
		
		return "publicador_ver";
	}
	
}
