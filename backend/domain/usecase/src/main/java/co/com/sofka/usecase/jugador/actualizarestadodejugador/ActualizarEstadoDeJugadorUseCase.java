package co.com.sofka.usecase.jugador.actualizarestadodejugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class ActualizarEstadoDeJugadorUseCase {
    private final JugadorRepository repository;

    public Mono<Jugador> actualizarEstadoDeJugador(String id){
        return repository.obtenerJugadorPorId(id)
                .map(jugador -> {
                    jugador.setEsActivo(jugador.getEsActivo().equals(Boolean.FALSE));
                    return jugador;
                    /*if (jugador.getEsActivo().equals(Boolean.FALSE)){
                        jugador.setEsActivo(true);
                    } else {
                        jugador.setEsActivo(false);
                    }*/
                })
                .flatMap(repository::guardar);
    }
}
