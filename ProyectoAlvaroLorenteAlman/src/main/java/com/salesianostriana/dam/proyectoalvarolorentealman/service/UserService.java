package com.salesianostriana.dam.proyectoalvarolorentealman.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.exception.ResourceNotFoundException;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.AddressRepository;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado usuario con el id: " + userId));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setAddress(userDetails.getAddress());

        return this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public User createUser(User user) {
        Address address = user.getAddress();
        address = this.addressRepository.save(address);
        user.setAddress(address);
        return this.userRepository.save(user);
    }
    
}

