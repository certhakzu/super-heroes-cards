package co.com.sofka.usecase.ronda.devolvertarjetasapostadas;


import co.com.sofka.model.ronda.gateways.RondaRepository;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


import java.util.ArrayList;
import java.util.HashSet;


@RequiredArgsConstructor
public class DevolverTarjetasApostadasUseCase {
    private final RondaRepository rondaRepository;


    public Flux<Tarjeta> devolverTarjetasApostadas(String idRonda) {

        return rondaRepository.obtenerRondaPorId(idRonda)
                .map(ronda -> new ArrayList<>(ronda.getApuesta().values())).flatMapMany(Flux::fromIterable);

                /*.map(ronda -> {
                    return ronda.getApuesta().entrySet().stream()
                            .map(apuesta -> {
                                return apuesta.getValue();
                            }).collect(Collectors.toList());
                }).flatMapMany(Flux::fromIterable);*/
    }

}
