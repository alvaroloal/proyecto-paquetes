package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Packet;

@Repository
public interface PacketRepository extends JpaRepository<Packet, Long>{

}
