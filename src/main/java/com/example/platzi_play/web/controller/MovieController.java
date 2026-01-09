package com.example.platzi_play.web.controller;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.SuggestRequestDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.services.MovieService;
import com.example.platzi_play.domain.services.PlatziPlayIAServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies")
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayIAServices aiService;

    public MovieController(MovieService movieService, PlatziPlayIAServices aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener Peliculas",
            description = "get all movies"
    )
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicula", example = "9") @PathVariable Long id) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody @Valid MovieDto movieDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.movieService.add(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
