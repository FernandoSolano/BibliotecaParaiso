package com.bibliotecaParaiso.prestamos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.CategoriaService;
import com.bibliotecaParaiso.prestamos.business.PrestamoService;
import com.bibliotecaParaiso.prestamos.form.CategoriaForm;
import com.bibliotecaParaiso.prestamos.form.PrestamoForm;

@Controller
public class PublicadorVerController {
	@Autowired
	private CategoriaService categoriaService;
	
	public PublicadorVerController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping("/categoria/ver")
	public String iniciar(Model model, CategoriaForm categoriaForm){
		model.addAttribute("categorias", this.categoriaService.select());
		
		return "categoria_ver";
	}
	
}
