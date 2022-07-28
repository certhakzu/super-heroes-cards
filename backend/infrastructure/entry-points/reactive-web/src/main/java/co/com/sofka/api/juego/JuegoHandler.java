package co.com.sofka.api.juego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.juego.agregarjugadoraljuego.AgregarJugadorAlJuegoUseCase;
import co.com.sofka.usecase.juego.crearjuego.CrearJuegoUseCase;
import co.com.sofka.usecase.juego.repartirmazos.RepartirMazosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JuegoHandler {

    private final CrearJuegoUseCase crearJuegoUseCase;
    private final AgregarJugadorAlJuegoUseCase agregarJugadorAlJuegoUseCase;

    private final RepartirMazosUseCase repartirMazosUseCase;

    public Mono<ServerResponse> crearJuego(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Juego.class)
                .flatMap(juego -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJuegoUseCase.crearJuego(juego), Juego.class));
    }

    public Mono<ServerResponse> agregarJugador(ServerRequest serverRequest){
        var id =serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Jugador.class)
                .flatMap(jugador -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(agregarJugadorAlJuegoUseCase.agregarJugadorAlJuego(id, jugador), Juego.class));
    }

    public Mono<ServerResponse> repartirMazos(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(repartirMazosUseCase.repartirMazos(id), Juego.class);
    }

}
