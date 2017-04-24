package com.bibliotecaParaiso.prestamos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bibliotecaParaiso.prestamos.business.PrestamoService;
import com.bibliotecaParaiso.prestamos.domain.Prestamo;
import com.bibliotecaParaiso.prestamos.form.DevolucionForm;
import com.bibliotecaParaiso.prestamos.form.PrestamoForm;

@Controller
public class DevolucionController {
	@Autowired
	private PrestamoService prestamoService;
	
	
	
	@RequestMapping("/devolucion")
	public String iniciar(Model model, DevolucionForm devolucionForm){
		model.addAttribute("prestamos", prestamoService.listaPrestamos());
		
		return "devolucion";
	}
	
	@RequestMapping(value = "/devolucion", method=RequestMethod.POST)
	public String devolucion(Model model, DevolucionForm devolucionForm){
		model.addAttribute("prestamos",prestamoService.listaPrestamos());
		
		int codigoPrestamo = devolucionForm.getCodigo();
		
		boolean resultado = prestamoService.devolucion(codigoPrestamo);
		
		if(resultado){
			model.addAttribute("mensaje", "Se ha realizado la devolución correctamente");
		}else{
			model.addAttribute("mensaje", "No se pudo devolver el libro");
			return "error";
		}
		model.addAttribute("prestamos", prestamoService.listaPrestamos());
		return "devolucion";
	}
	
	
}
