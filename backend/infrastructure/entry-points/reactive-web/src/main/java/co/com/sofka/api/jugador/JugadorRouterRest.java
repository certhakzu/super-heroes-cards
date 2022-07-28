package co.com.sofka.api.jugador;

import co.com.sofka.api.tarjeta.TarjetaHandler;
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
                .andRoute(GET("/api/jugador/retirarjugador/{id]"), jugadorHandler::retirarJugador)
                .andRoute(POST("/api/jugador/apostartarjeta/{id}"), jugadorHandler::apostarTarjeta); // {id} id del jugador y en el body se le pasa el id de la tarjeta apostada
                /*.andRoute(DELETE("/api/jugador/{id}"), jugadorHandler::eliminarJugador);*/

    }
}
