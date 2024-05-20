package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.model.Comment;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.CommentRepository;

import jakarta.transaction.Transactional;

@Service
public class CommentService {

    // Inyecta una instancia de CommentRepository para acceder a las operaciones CRUD
    @Autowired
    private CommentRepository commentRepository;

    // Inyecta una instancia de UserService para gestionar usuarios
    @Autowired
    private UserService userService;

    // Constructor para inyectar dependencias
    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    // Obtiene todos los comentarios
    public List<Comment> getAllComments() {
        return this.commentRepository.findAll();
    }
    
    // Crea un nuevo comentario
    @Transactional
    public Comment createComment(Comment comment, String username) {
        User user = this.userService.getUserByUsername(username);
        Comment newComment = new Comment();
        newComment.setDescription(comment.getDescription());
        newComment.setRating(comment.getRating());
        newComment.setUser(user);
        newComment.setDate(new Date());
        return this.commentRepository.save(newComment);
    }
}