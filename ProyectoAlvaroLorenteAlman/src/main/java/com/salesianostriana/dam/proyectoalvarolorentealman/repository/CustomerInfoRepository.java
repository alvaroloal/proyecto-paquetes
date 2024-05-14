package com.salesianostriana.dam.proyectoalvarolorentealman.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.CustomerInfo;
@Repository
public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer>{
	
}
