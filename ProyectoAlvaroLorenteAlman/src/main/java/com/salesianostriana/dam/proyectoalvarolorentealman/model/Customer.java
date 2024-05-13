package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CustomerInfo customerInfo;
	private Delivery deliveries;
	
	public Customer(Long id, String userName, String password) {
		super();
	}

}
