package co.com.sofka.api.tarjeta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class TarjetaRouterRest {
    @Bean
    public RouterFunction<ServerResponse> tarjetaRouterFunctionHandler(TarjetaHandler tarjetaHandler) {
        return route(GET("/api/listartarjetas"), tarjetaHandler::listarTarjetas)
                .andRoute(GET("/api/tarjeta/{id}"), tarjetaHandler::obtenerTarjeta)
                .andRoute(POST("/api/tarjeta/crear"), tarjetaHandler::crearTarjeta)
                .andRoute(POST("/api/tarjeta/actualizar"), tarjetaHandler::actualizarTarjeta)
                .andRoute(DELETE("/api/tarjeta/{id}"), tarjetaHandler::eliminarTarjeta); // No funciona
    }
}
