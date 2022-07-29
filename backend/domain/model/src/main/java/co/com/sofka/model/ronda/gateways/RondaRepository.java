package co.com.sofka.model.ronda.gateways;

import co.com.sofka.model.ronda.Ronda;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RondaRepository {
    Mono<Ronda> guardar(Ronda ronda);
    Flux<Ronda> listarTodasLasRondas();
    Mono<Ronda> obtenerRondaPorId(String idRonda); // devuelve id del ganador
}
