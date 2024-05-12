package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	private Long id;
	private Long numberOfDeliveries;
	private Double averageRating;
	private Double totalIncome;
}
