package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Entity(name="users")/*el nombre de la tabla es en plural ya que user es una palabra reservada en SQL*/
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)/*se crea una unica tabla, para poder discriminar en funcion 
																					del rol que tenga el usuario*/
/*al poner una clase abs se puede operar con objets con la clase abstracta nos obligamos definir parametros como el rol */
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)/*tipo IDENTITY para que al insertar un registro el id se autoincrementa*/
	private Long id;
	
	private String username;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName="id")/*clave foranea hacia la columna id 
																	de la clase Address*/
	private Address address;
	

	@Enumerated(EnumType.STRING)
	@Column(insertable=false,updatable=false)
	private UserRole role;

	public User(String username, String password, Address address) {
		this.username = username;
		this.password = password;
		this.address = address;
	}
	
	/*añado get y setRole ya que no se crean los getter y setter con la anotacion Data*/
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
}
