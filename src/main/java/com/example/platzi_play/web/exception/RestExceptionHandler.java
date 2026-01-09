package com.example.platzi_play.web.exception;

import com.example.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.example.platzi_play.domain.exception.MovieNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(MovieAlreadyExistsException e) {
        Error error = new Error("movie-already-exists", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotExistsException.class)
    public ResponseEntity<Error> handlerException(MovieNotExistsException e) {
        Error error = new Error("movie-not-exists", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return  ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception e) {
        Error error = new Error("unknown-error", e.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }

}
