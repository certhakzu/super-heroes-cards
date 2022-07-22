package co.com.sofka.model.tarjeta.gateways;

import co.com.sofka.model.tarjeta.Tarjeta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TarjetaRepository {
    Mono<Tarjeta> guardar(Tarjeta tarjeta);
    //Mono<Tarjeta> actualizar(Tarjeta tarjeta);
    //Mono<Tarjeta> eliminar(Tarjeta tarjeta);
    //Mono<Tarjeta> eliminarPorId(String id);
    Flux<Tarjeta> listarTarjetas();
}
