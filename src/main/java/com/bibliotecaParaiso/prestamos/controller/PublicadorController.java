package com.bibliotecaParaiso.prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicadorController {
	@RequestMapping("/publicador")
	public String iniciar(){
		
		return "publicador";
	}
}
