package com.salesianostriana.dam.proyectopaqueteriaalvarolorentealman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectopaqueteriaalvarolorentealman.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteServicio;
	
	@GetMapping("/list")
	public String lista(Model model) {
		model.addAttribute("clientes", clienteServicio.findAll());
		return "lista";
		
	}
}
