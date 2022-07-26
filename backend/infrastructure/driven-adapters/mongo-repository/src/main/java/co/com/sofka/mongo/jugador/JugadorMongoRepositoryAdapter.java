package co.com.sofka.mongo.jugador;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
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
        return repository.save(new JugadorDocument(
                jugador.getId(),
                jugador.getAlias(),
                jugador.getPuntos(),
                jugador.getMazo(),
                jugador.getEsActivo()
        )).flatMap(jugadorDocument -> Mono.just(jugador));
    }

    @Override
    public Mono<Jugador> obtenerJugadorPorId(String id) {
        return repository.findById(id)
                .map(jugadorDocument -> new Jugador(
                        jugadorDocument.getId(),
                        jugadorDocument.getAlias(),
                        jugadorDocument.getPuntos(),
                        jugadorDocument.getMazo(),
                        jugadorDocument.getEsActivo()
                ));
    }
}
