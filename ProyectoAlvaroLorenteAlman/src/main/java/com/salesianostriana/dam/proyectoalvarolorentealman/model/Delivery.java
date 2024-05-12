package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
	private Long id;
	private Packet content;
	private Transportation transportation;
	private CustomerInfo source;
	private CustomerInfo destination;
	private LocalDate departureDate;
	private LocalDate estimatedDate;
	private Status status;
	private Double price;
	private Invoice invoice;
	

}
