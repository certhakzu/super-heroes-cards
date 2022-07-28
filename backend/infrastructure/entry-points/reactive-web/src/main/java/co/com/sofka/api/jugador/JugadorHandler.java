package co.com.sofka.api.jugador;

import co.com.sofka.model.jugador.Jugador;

import co.com.sofka.usecase.jugador.apostartarjeta.ApostarTarjetaUseCase;
import co.com.sofka.usecase.jugador.crearjugador.CrearJugadorUseCase;
import co.com.sofka.usecase.jugador.obtenerjugadorporid.ObtenerJugadorPorIdUseCase;
import co.com.sofka.usecase.jugador.retirarjugador.RetirarJugadorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JugadorHandler {
    private final CrearJugadorUseCase crearJugadorUseCase;
    private final ObtenerJugadorPorIdUseCase obtenerJugadorPorIdUseCase;
    private final RetirarJugadorUseCase retirarJugadorUseCase;
    private final ApostarTarjetaUseCase apostarTarjetaUseCase;

    public Mono<ServerResponse> crearJugador(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Jugador.class) // Deberia ir un dto, pero vamos a pasar el model
                //.flatMap(tarjeta -> crearTarjetaUseCase.guardarTarjeta(tarjeta)) // flujo alterno para el proceso de almacenamiento
                .flatMap(jugador -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJugadorUseCase.crearJugador(jugador), Jugador.class));
    }

    public Mono<ServerResponse> obtenerJugador(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(obtenerJugadorPorIdUseCase.obtenerJugadorPorId(id), Jugador.class);
    }

    public Mono<ServerResponse> retirarJugador(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(retirarJugadorUseCase.retirarJugador(id), Jugador.class);
    }

    public Mono<ServerResponse> apostarTarjeta(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id"); // id de jugador

        return serverRequest
                .bodyToMono(String.class)
                .flatMap(s -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(apostarTarjetaUseCase.apostarTarjeta(id,s), Jugador.class));

    }
}
