package co.com.sofka.usecase.jugador.agregarpuntos;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarPuntosUseCase {
    private final JugadorRepository repository;

    public Mono<Jugador> agregarPuntos(String id){
        return repository.obtenerJugadorPorId(id)
                .map(jugador -> {
                    jugador.setPuntos(jugador.getPuntos() + 10);
                    return jugador;
                })
                .flatMap(repository::guardar);
    }
}
