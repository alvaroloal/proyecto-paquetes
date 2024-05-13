package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor
public class Admin extends User {
	@Id
	@GeneratedValue
	private Long id;
	//private List<Report> weeklyReports;
	
	public Admin(Long id, String userName, String password) {
		super();
	}

}
