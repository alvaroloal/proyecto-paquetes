package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Report;


public interface ReportRepository extends JpaRepository<Report, Long> {
    
}