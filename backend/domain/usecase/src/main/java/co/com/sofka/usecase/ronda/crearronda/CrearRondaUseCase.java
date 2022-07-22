package co.com.sofka.usecase.ronda.crearronda;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearRondaUseCase {
    private final RondaRepository repository;

    public Mono<Ronda> crearRonda(Ronda ronda){
        return repository.guardar(ronda);
    }
}
