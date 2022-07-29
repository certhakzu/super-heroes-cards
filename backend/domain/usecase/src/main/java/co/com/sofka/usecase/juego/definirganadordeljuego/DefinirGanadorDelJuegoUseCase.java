package co.com.sofka.usecase.juego.definirganadordeljuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class DefinirGanadorDelJuegoUseCase {
    private final JuegoRepository juegoRepository;


    public Mono<Juego> definirGanador(String idJuego){
        return juegoRepository.obtenerJuegoPorId(idJuego)
                .map(juego -> {
                    var ganador = juego.getJugadores().stream()
                            .filter(jugador -> jugador.getEsActivo())
                            .findFirst().get();
                    juego.setIdGanador(ganador.getId());
                    return juego;
                }).flatMap(juegoRepository::guardar);
    }
}
