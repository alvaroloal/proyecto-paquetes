package com.salesianostriana.dam.proyectoalvarolorentealman.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.CustomerInfo;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.CustomerInfoService;

@Controller
@RequestMapping
public class CustomerInfoController {
	
	@Autowired
	private CustomerInfoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<CustomerInfo> customers = service.listar();
		model.addAttribute("customers", customers);
		return "indexCustomer";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("customer", new CustomerInfo());
		return "form";
	}

	@PostMapping("/save")
	public String save(/*@Valid*/ CustomerInfo c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<CustomerInfo> customer = service.listarId(id);
		model.addAttribute("customer", customer);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	

}
