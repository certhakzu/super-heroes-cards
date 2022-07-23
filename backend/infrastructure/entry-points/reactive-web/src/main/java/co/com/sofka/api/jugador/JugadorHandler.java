package co.com.sofka.api.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.usecase.jugador.actualizarjugador.ActualizarJugadorUseCase;
import co.com.sofka.usecase.jugador.crearjugador.CrearJugadorUseCase;
import co.com.sofka.usecase.jugador.eliminarjugador.EliminarJugadorUseCase;
import co.com.sofka.usecase.jugador.listarjugadores.ListarJugadoresUseCase;
import co.com.sofka.usecase.jugador.obtenerjugadorporid.ObtenerJugadorPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JugadorHandler {
    private final CrearJugadorUseCase crearJugadorUseCase;
    private final ListarJugadoresUseCase listarJugadoresUseCase;
    private final EliminarJugadorUseCase eliminarJugadorUseCase;
    private final ActualizarJugadorUseCase actualizarJugadorUseCase;
    private final ObtenerJugadorPorIdUseCase obtenerJugadorPorIdUseCase;

    public Mono<ServerResponse> crearJugador(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Jugador.class) // Deberia ir un dto, pero vamos a pasar el model
                //.flatMap(tarjeta -> crearTarjetaUseCase.guardarTarjeta(tarjeta)) // flujo alterno para el proceso de almacenamiento
                .flatMap(jugador -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearJugadorUseCase.crearJugador(jugador), Jugador.class));
    }

    public Mono<ServerResponse> listarJugadores(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarJugadoresUseCase.listarJugadores(), Jugador.class);
    }

    public Mono<ServerResponse> eliminarJugador(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarJugadorUseCase.eliminarJugador(id), Jugador.class);
    }

    public Mono<ServerResponse> actualizarJugador(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return serverRequest
                .bodyToMono(Jugador.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(actualizarJugadorUseCase.actualizarJugador(id, element), Jugador.class));
    }

    public Mono<ServerResponse> obtenerJugador(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(obtenerJugadorPorIdUseCase.obtenerJugadorPorId(id), Jugador.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
