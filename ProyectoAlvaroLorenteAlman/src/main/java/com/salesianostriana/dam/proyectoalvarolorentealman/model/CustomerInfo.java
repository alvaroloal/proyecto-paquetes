package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zipCode;
	private String country;
	private String email;
	

}
