package com.example.platzi_play.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "platzi_play_peliculas")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;

    @Column(nullable = false, precision = 3)
    private Integer duracion;

    @Column(nullable = false, length = 40)
    private String genero;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(precision = 3, scale = 2)
    private BigDecimal clasificacion;

    @Column(nullable = false, length = 1)
    private String estado;

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public BigDecimal getClasificacion() {
        return clasificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setClasificacion(BigDecimal clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
