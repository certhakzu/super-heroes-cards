package co.com.sofka.usecase.jugador.retirarjugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.HashSet;

@RequiredArgsConstructor
public class RetirarJugadorUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> retirarse(String id) {
        return repository.obtenerJugadorPorId(id)
                .map(jugador -> {
                    jugador.setEsActivo(false);
                    jugador.getMazo().setTarjetas(new HashSet<>());
                    return jugador;
                })
                .flatMap(repository::guardar);
    }
}
