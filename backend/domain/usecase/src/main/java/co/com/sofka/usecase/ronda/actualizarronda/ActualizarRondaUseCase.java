package co.com.sofka.usecase.ronda.actualizarronda;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarRondaUseCase {
    private final RondaRepository repository;

    public Mono<Ronda> actualizarRonda(String id, Ronda ronda){
        return repository.actualizar(id, ronda);
    }
}
