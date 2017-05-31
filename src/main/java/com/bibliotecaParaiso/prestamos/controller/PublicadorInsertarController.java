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
public class PublicadorInsertarController {
	@Autowired
	private PublicadorService publicadorService;
	
	public PublicadorInsertarController(PublicadorService publicadorService) {
		super();
		this.publicadorService = publicadorService;
	}
	
	@RequestMapping("/publicador/insertar")
	public String iniciar(Model model, PublicadorForm publicadorForm){
		
		return "publicador_insertar";
	}
	
	@RequestMapping(value = "/publicador/insertar", method=RequestMethod.POST)
	public String devolucion(Model model, PublicadorForm publicadorForm){
		
		String nombre = publicadorForm.getNombre();
		String correo = publicadorForm.getCorreo();
		String lugar = publicadorForm.getLugar();
		
		int codigo = publicadorService.insert(nombre, lugar, correo);
		
		if(codigo != -1){
			model.addAttribute("mensaje", "El publicador se ha  insertado correctamente con el codigo "+ codigo);
		}else{
			model.addAttribute("mensaje", "No se pudo insertar el publicador");
		}
		
		return "publicador_insertar";
	}
	
	
}
