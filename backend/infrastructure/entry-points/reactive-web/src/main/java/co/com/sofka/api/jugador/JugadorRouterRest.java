package co.com.sofka.api.jugador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class JugadorRouterRest {
    @Bean
    public RouterFunction<ServerResponse> jugadorRouterFunctionHandler(JugadorHandler jugadorHandler) {

        return route(POST("/api/jugador/crear"), jugadorHandler::crearJugador)
                .andRoute(GET("/api/jugador/{id}"), jugadorHandler::obtenerJugador)
                .andRoute(GET("/api/jugador/retirarjugador/{id}"), jugadorHandler::retirarJugador)
                .andRoute(POST("/api/jugador/apostartarjeta/{id}"), jugadorHandler::apostarTarjeta) // {id} id del jugador y en el body se le pasa el id de la tarjeta apostada
                .andRoute(GET("/api/jugador/agregarpuntos/{id}"), jugadorHandler::agregarPuntos)
                .andRoute(POST("/api/jugador/actualizarmazo/{id}"), jugadorHandler::actualizarMazo); // Se le pasa el id del jugador en la url y el mazo nuevo en el cuerpo d ela petición
    }
}
