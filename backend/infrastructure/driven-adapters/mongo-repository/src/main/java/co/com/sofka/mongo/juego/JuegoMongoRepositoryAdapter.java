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
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Juego.class));
    }


    @Override
    public Mono<Juego> guardar(Juego juego) {
        return repository.save(new JuegoDocument(
                juego.getId(), // Se autogenera
                juego.getBaraja(), // De la BD
                juego.getRondas(), // Inicia en 0
                juego.getJugadores() // los jugadoes deben venir de Firebase
        )).flatMap(juegoDocument -> Mono.just(juego));
    }

    @Override
    public Mono<Juego> eliminarJuego(String id) {
        return null;
    }

    @Override
    public Mono<Juego> actualizarJuego(String id, Juego juego) {
        return null;
    }

    @Override
    public Flux<Juego> listarTodosLosJuegos() {
        return null;
    }

    @Override
    public Flux<Tarjeta> repartirCartas(Short numeroDeJugadores) {
        return null;
    }

    @Override
    public Mono<Boolean> validarJugador(Jugador jugador) {
        return null;
    }
}
