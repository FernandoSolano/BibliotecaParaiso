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
public class PublicadorInsertarController {
	@Autowired
	private CategoriaService categoriaService;
	
	public PublicadorInsertarController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping("/categoria/insertar")
	public String iniciar(Model model, CategoriaForm categoriaForm){
		
		return "categoria_insertar";
	}
	
	@RequestMapping(value = "/categoria/insertar", method=RequestMethod.POST)
	public String devolucion(Model model, CategoriaForm categoriaForm){
		
		String nombre = categoriaForm.getNombre();
		
		int codigo = categoriaService.insert(nombre);
		
		if(codigo != -1){
			model.addAttribute("mensaje", "La categoria se ha  insertado correctamente con el codigo "+ codigo);
		}else{
			model.addAttribute("mensaje", "No se pudo insertar la categoria");
		}
		
		return "categoria_insertar";
	}
	
	
}
