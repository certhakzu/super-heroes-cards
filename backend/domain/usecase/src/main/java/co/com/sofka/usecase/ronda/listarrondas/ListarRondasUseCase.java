package co.com.sofka.usecase.ronda.listarrondas;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarRondasUseCase {
    private final RondaRepository repository;

    public Flux<Ronda> listarRondas(){
        return repository.listarTodasLasRondas();
    }
}
