package co.com.sofka.usecase.ronda.obtenerrondaporid;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObtenerRondaPorIdUseCase {
    private final RondaRepository repository;

    public Mono<Ronda> obtenerRondaPorId(String idRonda){
        return repository.obtenerRondaPorId(idRonda);
    }
}
