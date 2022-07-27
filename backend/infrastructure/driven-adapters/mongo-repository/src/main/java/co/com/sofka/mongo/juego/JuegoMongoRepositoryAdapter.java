package co.com.sofka.mongo.juego;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.juego.gateways.JuegoRepository;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Repository
public class JuegoMongoRepositoryAdapter extends AdapterOperations<Juego, JuegoDocument, String, JuegoMongoDBRepository>
implements JuegoRepository {

    public JuegoMongoRepositoryAdapter(JuegoMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Juego.class));
    }


    @Override
    public Mono<Juego> guardar(Juego juego) {
        return null;
    }

    @Override
    public Flux<Juego> listarTodosLosJuegos() {
        return null;
    }

    @Override
    public Mono<Juego> obtenerJuegoPorId(String id) {
        return null;
    }
}
