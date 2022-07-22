package co.com.sofka.usecase.juego.actualizarjuego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarJuegoUseCase {
    private final JuegoRepository repository;

    public Mono<Juego> actualizarJuego(String id, Juego juego){
        return repository.actualizarJuego(id, juego);
    }
}
