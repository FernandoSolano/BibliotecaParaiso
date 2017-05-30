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
public class CategoriaBorrarController {
	@Autowired
	private CategoriaService categoriaService;
	
	public CategoriaBorrarController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping("/categoria/borrar")
	public String iniciar(Model model, CategoriaForm categoriaForm){
		model.addAttribute("categorias", this.categoriaService.select());
		
		return "categoria_borrar";
	}
	
	@RequestMapping(value = "/categoria/borrar", method=RequestMethod.POST)
	public String devolucion(Model model, CategoriaForm categoriaForm){
		
		int codigo = categoriaForm.getCodigo();
		
		boolean flag = categoriaService.borrar(codigo);
		
		if(flag){
			model.addAttribute("mensaje", "La categoria se ha borrado correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo borrar la categoria");
		}
		
		return "categoria_borrar";
	}
}
