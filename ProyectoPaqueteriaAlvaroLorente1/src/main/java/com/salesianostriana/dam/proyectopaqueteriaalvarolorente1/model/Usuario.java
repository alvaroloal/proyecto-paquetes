package com.salesianostriana.dam.proyectopaqueteriaalvarolorente1.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {

	@Id
	@GeneratedValue
	protected Long id;
	
	protected String nombreCompleto;
	protected String nombreUsuario;
	protected String password;
	protected String email;
	
}
