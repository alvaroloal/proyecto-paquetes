package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Packet;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.PacketRepository;

@Service
public class PacketService {

	@Autowired
	private PacketRepository data;

	public List<Packet> listar() {
		return (List<Packet>) data.findAll();
	}

	public Optional<Packet> listarId(Long id) {

		return data.findById(id);
	}

	public int save(Packet p) {
		int res = 0;
		Packet packet = data.save(p);
		if (!packet.equals(null)) {
			res = 1;

		}
		return res;
	}
	
	public void delete(Long id) {
		data.deleteById(id);
		
	}

}
