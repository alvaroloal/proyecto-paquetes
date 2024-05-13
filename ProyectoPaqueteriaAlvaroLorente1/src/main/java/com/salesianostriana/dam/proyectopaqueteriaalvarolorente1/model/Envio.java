package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "envio")
@Entity
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaEnvio;
    private Date fechaEntrega;
    @ManyToOne
    private Paquete paquete;
    @ManyToOne
    private Vehiculo vehiculo;
    @ManyToOne
    private Empleado empleado;
    
}

