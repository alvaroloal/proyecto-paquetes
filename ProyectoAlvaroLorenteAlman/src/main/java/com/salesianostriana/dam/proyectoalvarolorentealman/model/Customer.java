package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {
	
    public Customer() {
    	super(null,null,null);
		  this.setRole(UserRole.ROLE_CUSTOMER);
	}
    
    public Customer(String username, String password, Address address) {
		  super(username,password,address);
		  this.setRole(UserRole.ROLE_CUSTOMER);
	  }

}
