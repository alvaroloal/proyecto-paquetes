package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Delivery;


public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findBySourceId(Long id);
    
}
