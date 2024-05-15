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

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Customer;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.CustomerService;

@Controller
@RequestMapping
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService service) {
		this.customerService = service;
	}
	
	@GetMapping("/listar")
	public String showAll(Model model) {
		List<Customer> customers = customerService.listar();
		model.addAttribute("customers", customers);
		return "indexCustomer";
	}
	
	@GetMapping("/nuevo")
	public String viewForm(Model model) {
		model.addAttribute("customer", new Customer(null, null, null));
		return "formulario";
	}
	
	@PostMapping("/save")
	public String save(/*@Valid*/ Customer c, Model model) {
		customerService.save(c);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional<Customer> customer = customerService.listarId(id);
		model.addAttribute("customer", customer);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable Long id) {
		customerService.delete(id);
		return "redirect:/listar";
	}
}
