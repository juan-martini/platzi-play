package com.example.platzi_play.domain.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayIAServices {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de Peliculas {{platform}}.
            Usa menos de 120 caracteres y hazlo con el estilo de Platzi.
            """)
    String generateGreeting(@V("platform") String platform);

    @SystemMessage("""
            Eres un experto en cine que recomienda peliculas personalizadas segun los gustos del usuario.
            Debes recomendar maximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma PlaziPlay.
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}
