package co.com.sofka.usecase.tarjeta.obtenertarjetaporid;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObtenerTarjetaPorIdUseCase {
    private final TarjetaRepository repository;

    public Mono<Tarjeta> obtenerTarjetaPorId(String id){
        return repository.obtenerTarjetaPorId(id);
    }
}
