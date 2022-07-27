package co.com.sofka.usecase.jugador.actualizarmazodeJugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.mazo.Mazo;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarMazoDeJugadorUseCase {
    private final JugadorRepository repository;

    public Mono<Jugador> actualizarMazoDeJugador(String id, Mazo mazo){
        return repository.obtenerJugadorPorId(id)
                .map(jugador -> {
                    jugador.setMazo(mazo);
                    return jugador;
                }).flatMap(repository::guardar);
    }
}
