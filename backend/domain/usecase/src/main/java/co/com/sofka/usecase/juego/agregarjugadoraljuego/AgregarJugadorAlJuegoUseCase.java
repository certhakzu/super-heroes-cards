package co.com.sofka.usecase.juego.agregarjugadoraljuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.Jugador;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarJugadorAlJuegoUseCase {
    private final JuegoRepository juegoRepository;


    public Mono<Juego> agregarJugadorAlJuego(String idJuego, Jugador jugador){
        return juegoRepository.obtenerJuegoPorId(idJuego)
                .map(juego -> {
                    juego.getJugadores().add(jugador);
                    return juego;
                })
                .flatMap(juegoRepository::guardar);
    }
}
