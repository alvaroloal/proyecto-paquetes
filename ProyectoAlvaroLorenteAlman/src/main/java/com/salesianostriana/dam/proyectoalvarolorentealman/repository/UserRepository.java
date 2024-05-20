package com.salesianostriana.dam.proyectoalvarolorentealman.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	List<User> findAll();

    Optional<User> findByUsername(String username);

    boolean existsById(Long id);

    boolean existsByUsername(String username);

    void delete(User user);
}
