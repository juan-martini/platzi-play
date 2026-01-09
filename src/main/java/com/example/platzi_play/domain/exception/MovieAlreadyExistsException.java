package com.example.platzi_play.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String moviTitle) {
        super("La pelicula "+ moviTitle +" ya existe");
    }
}
