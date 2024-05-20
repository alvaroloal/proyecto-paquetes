package com.salesianostriana.dam.proyectoalvarolorentealman.exception;

public class ResourceNotFoundException extends RuntimeException {
	//Constructor que recibe un mensaje y lo pasa a la superclase RunTimeException
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
