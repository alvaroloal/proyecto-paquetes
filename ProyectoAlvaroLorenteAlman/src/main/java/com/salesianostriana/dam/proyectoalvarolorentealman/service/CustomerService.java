package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Customer;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.CustomerRepository;

public class CustomerService extends BaseServiceImpl<Customer, Long, CustomerRepository> {

	private List<Customer> list;
	private long nextId;

	public CustomerService() {
		nextId = 0;
		list = new ArrayList<Customer>();
	}

	public void add(Customer c) {
		nextId++;
		c.setId(nextId);
		list.add(c);
	}

	public List<Customer> getList() {
		return Collections.unmodifiableList(list);
	}

	public Customer findById(long id) {
		Customer tem = null;
		boolean exit = false;

		for (int i = 0; i < list.size() && !exit; i++) {
			if (list.get(i).getId() == id) {
				tem = list.get(i);
				exit = true;
			}
		}
		return tem;
	}

	public void editar(Customer c) {
		int num;
		if (c != null) {
			Optional<Customer> tem = findById(c.getId());
			num = list.indexOf(tem);
			list.set(num, c);
		}

		else {

		}

	}

	public void delete(long id) {
		list.remove(findById(id));
	}

}
