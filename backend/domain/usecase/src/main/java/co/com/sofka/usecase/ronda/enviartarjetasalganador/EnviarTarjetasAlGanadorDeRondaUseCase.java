package co.com.sofka.usecase.ronda.enviartarjetasalganador;

import co.com.sofka.model.ronda.gateways.RondaRepository;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EnviarTarjetasAlGanadorDeRondaUseCase {

    private final RondaRepository repository;

    public Flux<Tarjeta> enviarTarjetasAlGanadorDeRonda(String idRonda) {
        return repository.obtenerRondaPorId(idRonda)
                .map(ronda -> {
                    return ronda.getApuesta().entrySet().stream()
                            .map(apuesta -> {
                                return apuesta.getValue();
                            }).collect(Collectors.toList());
                }).flatMapMany(Flux::fromIterable);
    }
}
