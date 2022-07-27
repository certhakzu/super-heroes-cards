package co.com.sofka.usecase.jugador.apostartarjeta;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ApostarTarjetaUseCase {

    private final JugadorRepository repository;

    public Mono<Jugador> apostarTarjeta(String idJugador, String idTarjeta){
        return repository.obtenerJugadorPorId(idJugador)
                .map(jugador -> {
                    var tarjetaApostada =  jugador.getMazo().getTarjetas().stream()
                            .reduce((tarjetaRecorrido, tarjeta) -> (!tarjetaRecorrido.getId().equals(idTarjeta)) ? tarjeta : tarjetaRecorrido).get();
                    jugador.getMazo().getTarjetas().remove(tarjetaApostada);
                    return jugador;
                })
                .flatMap(repository::guardar);
    }
}
