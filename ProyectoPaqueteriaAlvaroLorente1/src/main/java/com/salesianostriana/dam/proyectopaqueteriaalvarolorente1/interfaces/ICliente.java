package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model.Cliente;
@Repository
public interface ICliente extends CrudRepository<Cliente, Integer>{

}
