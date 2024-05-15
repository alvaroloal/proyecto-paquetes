package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends User{
	
    public Customer (String username, String password, Address address) {
        super(username, password, address);
        this.setRole(UserRole.CUSTOMER);
    }

	

}