package co.com.sofka.mongo.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class JugadorMongoRepositoryAdapter extends AdapterOperations<Jugador, JugadorDocument, String, JugadorMongoDBRepository>
implements JugadorRepository {

    public JugadorMongoRepositoryAdapter(JugadorMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Jugador.class));
    }

    @Override
    public Mono<Jugador> guardar(Jugador jugador) {
        return null;
    }

    @Override
    public Mono<Jugador> eliminarJugador(String id) {
        return null;
    }

    @Override
    public Mono<Jugador> actualizarJugador(String id, Jugador jugador) {
        return null;
    }

    @Override
    public Flux<Jugador> listarTodosLosJugador() {
        return null;
    }
}
