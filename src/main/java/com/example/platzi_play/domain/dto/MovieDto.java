package com.example.platzi_play.domain.dto;

import com.example.platzi_play.domain.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record MovieDto(
        Long id,

        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @Min(value = 0, message = "La duracion debe ser mayor a 0")
        @NotNull(message = "No se puede capturar nulo")
        Integer duration,

        Genre genre,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser anterior a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "La clasificacion no pude ser menor a 0")
        @Max(value = 5, message = "La clasificacion no pude ser mayor a 5")
        Double rating,

        @NotNull(message = "La pelicula debe de tener un estado")
        Boolean state
) {
}
