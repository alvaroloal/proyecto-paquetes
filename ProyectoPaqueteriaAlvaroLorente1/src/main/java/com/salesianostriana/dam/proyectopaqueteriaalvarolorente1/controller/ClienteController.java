package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.interfaceService.IClienteService;
import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model.Cliente;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private IClienteService service;


	@GetMapping("/listar")
	public String listar(Model model) {
		List<Cliente> clientes = service.listar();
		model.addAttribute("clientes", clientes);
		return "index";
	}

	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "form";
	}

	@PostMapping("/save")
	public String save(/*@Valid*/ Cliente c, Model model) {
		service.save(c);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Cliente> cliente = service.listarId(id);
		model.addAttribute("cliente", cliente);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}

}
