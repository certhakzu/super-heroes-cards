package co.com.sofka.api.ronda;

import co.com.sofka.api.tarjeta.TarjetaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RondaRouterRest {

    @Bean
    public RouterFunction<ServerResponse> rondaRouterFunctionHandler(RondaHandler rondaHandler) {
        return route(POST("api/ronda"), rondaHandler::crearRonda)
                .andRoute(GET("/api/ronda"), rondaHandler::listarRondas)
                .andRoute(GET("/api/ronda/{id}"), rondaHandler::obtenerRondaPorId);
                //route(GET("/api/listarondas"), rondaHandler::listarTarjetas) // No funciona
                //.andRoute(GET("/api/ronda/{id}"), rondaHandler::obtenerTarjeta) // No funciona
                //.andRoute(POST("/api/ronda/crear"), rondaHandler::crearRonda) // No funciona
                //.andRoute(POST("/api/ronda/actualizar"), rondaHandler::actualizarTarjeta); // No funciona
    }
}
