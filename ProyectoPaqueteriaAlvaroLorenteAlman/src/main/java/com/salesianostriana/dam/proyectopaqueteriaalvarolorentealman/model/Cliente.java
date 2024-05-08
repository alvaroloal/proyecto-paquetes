package com.salesianostriana.dam.proyectopaqueteriaalvarolorentealman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue
	private long id;	
	private String nombre;
	private String apellidos;
	private String email;
	private String telefono;
	private String direccion;
	private String numeroTarjeta;
	
	
	

}
