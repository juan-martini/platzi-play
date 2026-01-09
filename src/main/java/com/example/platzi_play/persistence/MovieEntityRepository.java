package com.example.platzi_play.persistence;

import com.example.platzi_play.domain.dto.MovieDto;
import com.example.platzi_play.domain.dto.UpdateMovieDto;
import com.example.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.example.platzi_play.domain.exception.MovieNotExistsException;
import com.example.platzi_play.domain.repository.MovieRepository;
import com.example.platzi_play.persistence.crud.CrudMovieEntity;
import com.example.platzi_play.persistence.entity.MovieEntity;
import com.example.platzi_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null){
            throw new MovieAlreadyExistsException(movieDto.title());
        }

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null) {
            throw new MovieNotExistsException(id);
        };

        /*
        movieEntity.setTitulo(updateMovieDto.title());
        movieEntity.setFechaEstreno(updateMovieDto.releaseDate());
        movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDto.rating()));
        movieEntity.setEstado(String.valueOf(updateMovieDto.state()));
         */

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null) {
            throw new MovieNotExistsException(id);
        };

        this.crudMovieEntity.deleteById(id);
    }
}
