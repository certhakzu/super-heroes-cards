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
public RouterFunction<ServerResponse> routerFunction(TarjetaHandler tarjetaHandler) {
    return route(POST("/api/usecase/creartarjeta"), tarjetaHandler::crearTarjeta);
            //.andRoute(GET("/api/usecase/listartarjetas"), tarjetaHandler::listarTarjetas);

    }
}
