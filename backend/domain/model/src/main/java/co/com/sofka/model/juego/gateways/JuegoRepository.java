package co.com.sofka.model.juego.gateways;

import co.com.sofka.model.juego.Juego;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JuegoRepository {
    Mono<Juego> guardar(Juego juego);
    Mono<Juego> eliminarJuego(String id);
    Mono<Juego> actualizarJuego(String id, Juego juego);
    Flux<Juego> listarTodosLosJuegos();

    // repartir cartas
    // validar usuario
}
