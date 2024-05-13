package com.salesianostriana.dam.proyectoalvarolorentealman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Customer;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService service) {
		this.customerService = service;
	}
	
	@GetMapping({"/", "/list"})
	public String showAll(Model model) {
		model.addAttribute("list", customerService.getList());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String viewForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "formulario";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("customer") Customer c) {
		customerService.add(c);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	

}
