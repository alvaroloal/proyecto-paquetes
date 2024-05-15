package com.salesianostriana.dam.proyectoalvarolorentealman.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(LandingController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        log.info("Getting all users");
        return this.userService.getAllUsers();
    }
    
    
}

