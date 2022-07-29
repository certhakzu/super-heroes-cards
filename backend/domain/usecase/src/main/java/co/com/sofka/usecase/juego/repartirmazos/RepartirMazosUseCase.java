package co.com.sofka.usecase.juego.repartirmazos;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.mazo.Mazo;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RepartirMazosUseCase {
    private final JuegoRepository juegoRepository;

    // para este punto ya el jueo deberia tener las cartas en su baraja, y los jugadores (con mazos vacios) asignados
    public Mono<Juego> repartirMazos(String idJuego){
        var numeroTotalDeTarjetas = juegoRepository.obtenerJuegoPorId(idJuego).map(juego -> juego.getBaraja().size()).block();
        var numeroDeJugadores = juegoRepository.obtenerJuegoPorId(idJuego).map(juego -> juego.getJugadores().size()).block();
        var numeroDeTarjetasPorJugador = (Integer) (numeroTotalDeTarjetas / numeroDeJugadores);

        return juegoRepository.obtenerJuegoPorId(idJuego)
                .map(juego -> {
                    var jugador =juego.getJugadores().stream()
                            .peek(jugador1 -> { // lo reemplacé por el map porque con este no tengo que retortar lo que estoy iterando
                                var tarjetasRevueltas = List.copyOf(juego.getBaraja());
                                Collections.shuffle(tarjetasRevueltas);

                                var listMazoDeJugador = tarjetasRevueltas.subList(0, numeroDeTarjetasPorJugador);
                                var setMazoDeJugador = Set.copyOf(listMazoDeJugador);
                                jugador1.setMazo(new Mazo(setMazoDeJugador));

                                var tarjetasActualizadas =juego.getBaraja().stream()
                                        .filter(tarjeta -> tarjetasRevueltas.contains(tarjeta) == false)
                                        .collect(Collectors.toSet());
                                juego.setBaraja(tarjetasActualizadas);
                            }).collect(Collectors.toSet());
                    juego.setJugadores(jugador);
                    return juego;
                })
                .flatMap(juegoRepository::guardar);
    }
}
