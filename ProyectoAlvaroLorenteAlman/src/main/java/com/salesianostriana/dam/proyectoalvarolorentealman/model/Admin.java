package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@DiscriminatorValue("ROLE_ADMIN")
public class Admin extends User {
	
	/*creo el constrcutor para crear el contrato*/
	  public Admin() {
		  super(null,null,null);
		  this.setRole(UserRole.ROLE_ADMIN);
	  }
	  
	  public Admin(String username, String password, Address address) {
		  super(username,password,address);
		  this.setRole(UserRole.ROLE_ADMIN);
	  }

}
