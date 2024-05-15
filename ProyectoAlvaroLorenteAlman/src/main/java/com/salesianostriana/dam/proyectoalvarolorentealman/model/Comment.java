package com.salesianostriana.dam.proyectoalvarolorentealman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;


@Entity(name="comment")
@Data
public class Comment {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    @SequenceGenerator(name="comment_seq", sequenceName="comment_seq", allocationSize = 1)
	private Long id;
	private Customer user;
	private Double rating;
	private String description;

}
