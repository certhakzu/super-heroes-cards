package co.com.sofka.api.tarjeta;

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
public class TarjetaHandler {
//private  final UseCase useCase;
//private  final UseCase2 useCase2;

    private final CrearTarjetaUseCase crearTarjetaUseCase;
    /*public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }*/

    public Mono<ServerResponse> crearTarjeta(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Tarjeta.class) // Deberia ir un dto, pero vamos a pasar el model
                .flatMap(tarjeta -> crearTarjetaUseCase.guardarTarjeta(tarjeta)) // flujo alterno para el proceso de almacenamiento
                .flatMap(tarjeta -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(tarjeta), Tarjeta.class));
    }

    public Flux<ServerResponse> listarTarjetas(ServerRequest serverRequest) {
        return serverRequest.bodyToFlux(Tarjeta.class)
                .flatMap(tarjeta -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(tarjeta), Tarjeta.class));
        //return ServerResponse.ok().bodyValue("");
    }
}
