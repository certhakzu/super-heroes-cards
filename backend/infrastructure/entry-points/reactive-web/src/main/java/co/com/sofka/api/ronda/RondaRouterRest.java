package co.com.sofka.api.ronda;


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
                .andRoute(GET("/api/ronda/definirganador/{id}"), rondaHandler::definirGanadorDeRonda)
                .andRoute(GET("/api/ronda/dartarjetasaganador/{id}"), rondaHandler::darTarjetasAlGanadorDeRonda);
    }
}
