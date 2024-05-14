package com.salesianostriana.dam.proyectoalvarolorentealman.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Packet;

import com.salesianostriana.dam.proyectoalvarolorentealman.service.PacketService;

@Controller
@RequestMapping
public class PacketController {
	
	@Autowired
	private PacketService service;
	
	@GetMapping("/listarPacket")
	public String listar(Model model) {
		List<Packet> packets = service.listar();
		model.addAttribute("packets", packets);
		return "indexPacket";
		
		
	}

}
