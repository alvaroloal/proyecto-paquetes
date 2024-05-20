package com.salesianostriana.dam.proyectoalvarolorentealman.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
