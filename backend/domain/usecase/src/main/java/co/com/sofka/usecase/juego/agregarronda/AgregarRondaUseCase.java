package co.com.sofka.usecase.juego.agregarronda;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;

import co.com.sofka.model.ronda.Ronda;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AgregarRondaUseCase {

    private final JuegoRepository juegoRepository;

    public Mono<Juego> agregarRonda(String idJuego, Ronda ronda){
        return juegoRepository.obtenerJuegoPorId(idJuego)
                .map(juego -> {
                    var rondas = juego.getRondas();
                    rondas.add(ronda);
                    juego.setRondas(rondas);
                    return juego;
                }).flatMap(juegoRepository::guardar);
    }
}
