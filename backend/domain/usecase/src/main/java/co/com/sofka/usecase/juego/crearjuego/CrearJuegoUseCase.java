package co.com.sofka.usecase.juego.crearjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Set;

@RequiredArgsConstructor
public class CrearJuegoUseCase {
    private final JuegoRepository juegoRepository;
    private final TarjetaRepository tarjetaRepository;

    public Mono<Juego> crearJuego(Juego juego){

        return tarjetaRepository.listarTodasLasTarjetas()
                .collectList()
                .map(tarjetas -> {
                    var setDeTarjetas = Set.copyOf(tarjetas);
                    juego.setBaraja(setDeTarjetas);
                    return juego;
                })
                .flatMap(juegoRepository::guardar);
    }
}
