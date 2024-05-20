package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	
	
	
}
