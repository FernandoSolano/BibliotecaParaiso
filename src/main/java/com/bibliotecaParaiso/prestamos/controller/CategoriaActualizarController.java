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
public class CategoriaActualizarController {
	@Autowired
	private CategoriaService categoriaService;
	
	public CategoriaActualizarController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping("/categoria/actualizar")
	public String iniciar(Model model, CategoriaForm categoriaForm){
		model.addAttribute("categorias", this.categoriaService.select());
		
		return "categoria_actualizar";
	}
	
	@RequestMapping(value = "/categoria/actualizar", method=RequestMethod.POST)
	public String devolucion(Model model, CategoriaForm categoriaForm){
		
		int codigo = categoriaForm.getCodigo();
		String nombre = categoriaForm.getNombre();
		
		boolean flag = categoriaService.actualizar(codigo, nombre);
		
		if(flag){
			model.addAttribute("mensaje", "La categoria se ha actualizado correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo actualizar la categoria");
		}
		
		return "categoria_actualizar";
	}
}
