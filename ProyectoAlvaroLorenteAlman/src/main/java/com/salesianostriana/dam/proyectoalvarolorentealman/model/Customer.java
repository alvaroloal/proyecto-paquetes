package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
public class Customer extends User {
	private CustomerInfo customerInfo;
	private Delivery deliveries;
	
	public Customer(Long id, String userName, String password) {
		super();
	}

}
