package com.example.platzi_play.domain.services;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Tool("Busca todas las peliculas que existan dentro de la plataforma")
    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(Long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void delete(Long id) {
        this.movieRepository.delete(id);
    }
}
