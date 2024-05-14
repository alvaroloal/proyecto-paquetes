package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.CustomerInfo;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.CustomerInfoRepository;

@Service
public class CustomerInfoService {
	
	@Autowired
	private CustomerInfoRepository data;
	
	public List<CustomerInfo> listar() {
		return (List<CustomerInfo>) data.findAll();
	}

	public Optional<CustomerInfo> listarId(int id) {
		return data.findById(id);
	}

	public int save(CustomerInfo c) {
		int res = 0;
		CustomerInfo customer = data.save(c);
		if (!customer.equals(null)) {
			res = 1;
		}
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);

	}

}
