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
import com.bibliotecaParaiso.prestamos.form.PublicadorForm;

@Controller
public class PublicadorBorrarController {
	@Autowired
	private PublicadorService publicadorService;
	
	public PublicadorBorrarController(PublicadorService publicadorService) {
		super();
		this.publicadorService = publicadorService;
	}
	
	@RequestMapping("/publicador/borrar")
	public String iniciar(Model model, PublicadorForm publicadorForm){
		model.addAttribute("publicadores", this.publicadorService.select());
		
		return "publicador_borrar";
	}
	
	@RequestMapping(value = "/publicador/borrar", method=RequestMethod.POST)
	public String devolucion(Model model, PublicadorForm publicadorForm){
		
		int codigo = publicadorForm.getCodigo();
		
		boolean flag = publicadorService.borrar(codigo);
		
		if(flag){
			model.addAttribute("mensaje", "El publicador se ha borrado correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo borrar el publicador");
		}
		
		return "publicador_borrar";
	}
}
