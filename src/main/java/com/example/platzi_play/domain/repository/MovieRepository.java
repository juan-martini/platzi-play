package com.example.platzi_play.domain.repository;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(Long id, UpdateMovieDto updateMovieDto);
    void delete(Long id);

}
