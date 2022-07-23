package co.com.sofka.usecase.jugador.obtenerjugadorporid;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObtenerJugadorPorIdUseCase {
    private final JugadorRepository repository;

    public Mono<Jugador> obtenerJugadorPorId(String id){
        return repository.obtenerJugadorPorId(id);
    }
}
