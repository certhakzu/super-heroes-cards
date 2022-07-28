package co.com.sofka.usecase.ronda.dartarjetasalganador;


import co.com.sofka.model.ronda.gateways.RondaRepository;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


import java.util.HashSet;


@RequiredArgsConstructor
public class DarTarjetasAlGanadorDeRondaUseCase {
    private final RondaRepository rondaRepository;


    public Flux<Tarjeta> darTarjetasAlGanadorDeRonda(String idRonda) {

        return rondaRepository.obtenerRondaPorId(idRonda)
                .map(ronda -> new HashSet<>(ronda.getApuesta().values())).flatMapMany(Flux::fromIterable);
        /*
        .map(ronda -> {
                    var tarjetas = ronda.getApuesta().entrySet().stream()
                            .map(apuesta -> apuesta.getValue())
                            .collect(Collectors.toSet());
                    return tarjetas;
                }).flatMapMany(Flux::fromIterable);
         */
    }

}
