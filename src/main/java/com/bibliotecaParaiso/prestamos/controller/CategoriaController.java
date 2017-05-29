package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoriaController {
	@RequestMapping("/categoria")
	public String iniciar(){
		
		return "categoria";
	}
}
