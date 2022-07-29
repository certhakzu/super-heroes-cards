package co.com.sofka.usecase.ronda.establecerapuesta;

import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
public class EstablecerApuestaUseCase {

    private final RondaRepository repository;

    public Mono<Ronda> establecerApuesta(String idRonda, Map<String, Tarjeta> apuesta){
        return repository.obtenerRondaPorId(idRonda)
                .map(ronda -> {
                    ronda.setApuesta(apuesta);
                    return ronda;
                })
                .flatMap(repository::guardar);
    }
}
