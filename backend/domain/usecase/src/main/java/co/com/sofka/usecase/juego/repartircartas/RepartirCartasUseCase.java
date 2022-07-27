package co.com.sofka.usecase.juego.repartircartas;

import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Set;

@RequiredArgsConstructor
public class RepartirCartasUseCase {
    private final JuegoRepository repository;


}
