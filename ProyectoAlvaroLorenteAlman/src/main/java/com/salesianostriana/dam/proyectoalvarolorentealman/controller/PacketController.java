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
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Packet;

import com.salesianostriana.dam.proyectoalvarolorentealman.service.PacketService;

@Controller
@RequestMapping
public class PacketController {
	
	@Autowired
	private PacketService packetService;
	
	@GetMapping("/listarPacket")
	public String listar(Model model) {
		List<Packet> packets = packetService.listar();
		model.addAttribute("packets", packets);
		return "indexPacket";
	}
	
	@GetMapping("/nuevoPacket")
	public String viewForm(Model model) {
		model.addAttribute("packet", new Packet());
		return "formularioPacket";
	}
	
	@PostMapping("/save")
	public String save(Packet p, Model model) {
		packetService.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Long id, Model model) {
		Optional <Packet> packet= packetService.listarId(id);
		model.addAttribute("packet", packet);
		return "formPacket";
	}
	
	

}
