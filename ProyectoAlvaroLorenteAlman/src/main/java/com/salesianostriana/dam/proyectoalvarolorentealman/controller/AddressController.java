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

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.AddressService;

@Controller
@RequestMapping
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Address> customers = service.listar();
		model.addAttribute("customers", customers);
		return "indexCustomer";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("customer", new Address());
		return "form";
	}

	@PostMapping("/save")
	public String save(/*@Valid*/ Address c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Address> address = service.listarId(id);
		model.addAttribute("address", address);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable Long id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	

}

