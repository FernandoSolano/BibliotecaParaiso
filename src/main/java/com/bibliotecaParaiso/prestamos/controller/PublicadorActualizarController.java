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
public class PublicadorActualizarController {
	@Autowired
	private PublicadorService publicadorService;
	
	public PublicadorActualizarController(PublicadorService publicadorService) {
		super();
		this.publicadorService = publicadorService;
	}
	
	@RequestMapping("/publicador/actualizar")
	public String iniciar(Model model, PublicadorForm publicadorForm){
		model.addAttribute("publicadores", this.publicadorService.select());
		
		return "publicador_actualizar";
	}
	
	@RequestMapping(value = "/publicador/actualizar", method=RequestMethod.POST)
	public String devolucion(Model model, PublicadorForm publicadorForm){
		
		int codigo = publicadorForm.getCodigo();
		String nombre = publicadorForm.getNombre();
		String lugar = publicadorForm.getLugar();
		String correo = publicadorForm.getCorreo();
		
		boolean flag = publicadorService.actualizar(codigo, nombre, lugar, correo);
		
		if(flag){
			model.addAttribute("mensaje", "El publicador se ha actualizado correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo actualizar el publicador");
		}
		
		return "publicador_actualizar";
	}
}
