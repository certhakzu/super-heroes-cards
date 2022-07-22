package co.com.sofka.usecase.juego.eliminarjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarJuegoUseCase {
    private final JuegoRepository repository;

    public Mono<Juego> eliminarJuego(String id){
        return repository.eliminarJuego(id);
    }
}
