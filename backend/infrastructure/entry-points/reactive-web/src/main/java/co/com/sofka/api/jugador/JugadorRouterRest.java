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
        return route(GET("/api/listarjugadores"), jugadorHandler::listarJugadores)
                .andRoute(GET("/api/jugador/{id}"), jugadorHandler::obtenerJugador)
                .andRoute(POST("/api/jugador/crear"), jugadorHandler::crearJugador)
                .andRoute(POST("/api/jugador/actualizar"), jugadorHandler::actualizarJugador)
                .andRoute(DELETE("/api/jugador/{id}"), jugadorHandler::eliminarJugador);
    }
}
