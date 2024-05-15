package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Customer;

import com.salesianostriana.dam.proyectoalvarolorentealman.repository.CustomerRepository;

import lombok.Data;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository data;
	
	public List<Customer> listar() {
		return (List<Customer>) data.findAll();
	}

	public Optional<Customer> listarId(Long id) {
		return data.findById(id);
	}

	public int save(Customer c) {
		int res = 0;
		Customer customer = data.save(c);
		if (!customer.equals(null)) {
			res = 1;
		}
		return res;
	}

	public void delete(Long id) {
		data.deleteById(id);
	}

}
