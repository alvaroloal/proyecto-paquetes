package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
	@Id
	@GeneratedValue
	private Long id;
	
	private Packet content;
	
	@Enumerated(EnumType.STRING)
	private TransportationType transportationType;
	
	private CustomerInfo source;
	private CustomerInfo destination;
	private LocalDate departureDate;
	private LocalDate estimatedDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private Double price;
	
	private Invoice invoice;
	
	
	

}
