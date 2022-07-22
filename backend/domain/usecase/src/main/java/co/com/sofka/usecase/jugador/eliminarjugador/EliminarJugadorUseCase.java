package co.com.sofka.usecase.jugador.eliminarjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarJugadorUseCase {
    private final JugadorRepository repository;

    public Mono<Jugador> eliminarJugador(String id){
        return repository.eliminarJugador(id);
    }
}
