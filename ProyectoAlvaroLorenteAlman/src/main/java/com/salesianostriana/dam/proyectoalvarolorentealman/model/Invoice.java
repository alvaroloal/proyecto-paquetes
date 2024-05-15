package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
	private Long id;
	private Double price;
	private Double tax;
	private LocalDate issueDate;
	private Address address;
	private String companyInfo;
	
	

}
