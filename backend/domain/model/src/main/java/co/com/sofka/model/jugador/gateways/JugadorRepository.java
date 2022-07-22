package co.com.sofka.model.jugador.gateways;

import co.com.sofka.model.jugador.Jugador;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JugadorRepository {

    Mono<Jugador> guardar(Jugador jugador);
    Mono<Jugador> eliminarJugador(String id);
    Mono<Jugador> actualizarJugador(String id, Jugador jugador);
    Flux<Jugador> listarTodosLosJugador();
}
