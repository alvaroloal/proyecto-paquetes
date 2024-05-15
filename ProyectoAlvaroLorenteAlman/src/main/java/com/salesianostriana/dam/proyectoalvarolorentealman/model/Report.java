package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "report")
public class Report {
	private Long id;
	private Long numberOfDeliveries;
	private Double averageRating;
	private Double totalIncome;
}