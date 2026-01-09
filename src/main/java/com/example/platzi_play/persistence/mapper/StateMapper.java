package com.example.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public interface StateMapper {

    @Named("stateToBoolean")
    public static Boolean stateToBoolean(String estado) {
        return estado.equalsIgnoreCase("D");
    }

    @Named("stateToBoolean")
    public static String booleanToState(Boolean state) {
        String estado = "N";
        if(state) {
            estado = "D";
        }

        return estado;
    }
}
