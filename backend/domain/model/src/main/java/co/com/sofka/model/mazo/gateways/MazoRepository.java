package co.com.sofka.model.mazo.gateways;

import co.com.sofka.model.mazo.Mazo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MazoRepository {
    Mono<Mazo> guardar(Mazo mazo);
    Flux<Mazo> listarTodos();
}
