package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.interfaceService.IClienteService;
import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.interfaces.ICliente;
import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model.Cliente;
@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ICliente data;
	
	public List<Cliente> listar() {
		return (List<Cliente>) data.findAll();
	}

	public Optional<Cliente> listarId(int id) {
		return data.findById(id);
	}

	public int save(Cliente c) {
		int res = 0;
		Cliente cliente = data.save(c);
		if (!cliente.equals(null)) {
			res = 1;
		}
		return res;
	}

	public void delete(int id) {
		data.deleteById(id);

	}

}
