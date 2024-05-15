package com.salesianostriana.dam.proyectoalvarolorentealman.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository data;
	
	public List<Address> listar() {
		return (List<Address>) data.findAll();
	}

	public Optional<Address> listarId(Long id) {
		return data.findById(id);
	}

	public int save(Address c) {
		int res = 0;
		Address address = data.save(c);
		if (!address.equals(null)) {
			res = 1;
		}
		return res;
	}

	public void delete(Long id) {
		data.deleteById(id);

	}

}

