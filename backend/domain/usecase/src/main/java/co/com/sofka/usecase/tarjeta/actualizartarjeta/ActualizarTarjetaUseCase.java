package co.com.sofka.usecase.tarjeta.actualizartarjeta;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ActualizarTarjetaUseCase {
    private final TarjetaRepository repository;

    public Mono<Tarjeta> actualizarTarjeta(String id, Tarjeta tarjeta){
        return repository.actualizar(id, tarjeta);
    }
}
