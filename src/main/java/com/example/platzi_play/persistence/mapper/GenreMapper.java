package com.example.platzi_play.persistence.mapper;

import com.example.platzi_play.domain.Genre;
import org.mapstruct.Named;

public interface GenreMapper {

    @Named("stringToGenre")
    public static Genre stringToGenre(String genero) {
        if(genero == null) {
            return null;
        }

        return switch (genero.toUpperCase()) {
            case "ACCION" -> Genre.ACTION;
            case "COMEDIA" -> Genre.COMEDY;
            case "DRAMA" -> Genre.DRAMA;
            case "ANIMADA" -> Genre.ANIMATION;
            case "TERROR" -> Genre.HORROR;
            case "CIENCIA_FICCION" -> Genre.SCI_FI;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genero) {
        if (genero == null) {
            return null;
        }

        return switch(genero) {
            case ACTION -> "ACCION";
            case COMEDY -> "COMEDIA";
            case DRAMA -> "DRAMA";
            case ANIMATION -> "ANIMADA";
            case HORROR -> "TERROR";
            case SCI_FI -> "CIENCIA_FICCION";
            default -> null;
        };
    }
}
