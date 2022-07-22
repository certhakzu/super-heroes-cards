package co.com.sofka.api.juego;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.usecase.creartarjeta.CrearTarjetaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JuegoHandler {

}
