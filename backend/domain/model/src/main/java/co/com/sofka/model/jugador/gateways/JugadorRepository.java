package co.com.sofka.model.jugador.gateways;

import co.com.sofka.model.jugador.Jugador;

import reactor.core.publisher.Mono;



public interface JugadorRepository {

    Mono<Jugador> guardar(Jugador jugador);
    Mono<Jugador> obtenerJugadorPorId(String id);
}
