package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.interfaceService;

import java.util.List;
import java.util.Optional;

import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model.Cliente;

public interface IClienteService {
	public List<Cliente> listar();

	public Optional<Cliente> listarId(int id);

	public int save(Cliente c);

	public void delete(int id);

}