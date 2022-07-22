package co.com.sofka.usecase.tarjeta.eliminartarjeta;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class EliminarTarjetaUseCase {
    private final TarjetaRepository repository;

    public Mono<Tarjeta> eliminarTarjeta(String id){
        return repository.eliminar(id);
    }
}
