package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Invoice;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}

