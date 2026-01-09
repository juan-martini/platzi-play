package com.example.platzi_play.domain.exception;

public class MovieNotExistsException extends RuntimeException {
    public MovieNotExistsException(Long id) {
        super("La pelicula con id " + id + " no existe");
    }
}
