package co.com.sofka.usecase.ronda.definirganadroderonada;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DefinirGanadorDeRondaUseCase {
    private final RondaRepository repository;

    public Mono<Ronda> definirGanadorDeRonda(String id) {
        return repository.obtenerRondaPorId(id)
                .map(ronda -> {
                    var idGanador =
                            ronda.getApuesta()
                                    .entrySet()
                                    .stream()
                                    .reduce(((o1, o2) -> (o1.getValue().getPoder() > o2.getValue().getPoder()) ? o1 : o2))
                                    .get()
                                    .getKey();
                    ronda.setIdGanador(idGanador);
                    return ronda;
                })
                .flatMap(repository::guardar);
    }
}