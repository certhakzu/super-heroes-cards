package co.com.sofka.api.juego;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class JuegoRouterRest {

    @Bean
    public RouterFunction<ServerResponse> juegoRouterFunctionHandler(JuegoHandler juegoHandler) {
        return route(POST("/api/juego"), juegoHandler::crearJuego)

                .andRoute(POST("/api/juego/agregarjugador/{id}"), juegoHandler::agregarJugador)
                .andRoute(GET("/api/juego/repartirmazos/{id}"), juegoHandler::repartirMazos)
                .andRoute(POST("/api/juego/agregaronda/{id}"), juegoHandler::agregarJugador) // en la url se le pasa el id del jeugo y en el cuerpo la ronda que se le va a agregar
                .andRoute(GET("/api/juego/definirganador/{id}"), juegoHandler::definirGanador);

    }
}
