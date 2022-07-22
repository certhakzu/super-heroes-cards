package co.com.sofka.usecase.tarjeta.creartarjeta;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CrearTarjetaUseCase {
    private final TarjetaRepository repository; // No se inyecta con @Autowired porque no es de infraestructura
    public Mono<Tarjeta> guardarTarjeta(Tarjeta tarjeta){
        return repository.guardar(tarjeta);
    }
}
