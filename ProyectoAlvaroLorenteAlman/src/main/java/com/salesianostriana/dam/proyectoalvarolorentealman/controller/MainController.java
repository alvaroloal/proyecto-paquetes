package com.salesianostriana.dam.proyectoalvarolorentealman.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String bienvenida(Model model) {
		return "index";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		return "dashboard";
	}
	
	
	
	

}

