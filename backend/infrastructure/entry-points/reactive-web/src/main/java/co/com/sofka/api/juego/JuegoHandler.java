package co.com.sofka.api.juego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.juego.crearjuego.CrearJuegoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JuegoHandler {

    private final CrearJuegoUseCase crearJuegoUseCase;

    public Mono<ServerResponse> crearJuego(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Juego.class)
                .flatMap(juego -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJuegoUseCase.crearJuego(juego), Juego.class));
    }

}
