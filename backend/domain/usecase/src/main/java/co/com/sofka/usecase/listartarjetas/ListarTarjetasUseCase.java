package co.com.sofka.usecase.listartarjetas;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarTarjetasUseCase {
    private final TarjetaRepository repository;

    public Flux<Tarjeta> listarTarjetas(){
        return repository.listarTarjetas();
    }
}
