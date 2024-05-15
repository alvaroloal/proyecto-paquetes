package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import lombok.EqualsAndHashCode;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends User{

    public Admin(String username, String password, Address address) {
        super(username, password, address);
        this.setRole(UserRole.ADMIN);
    }

}

