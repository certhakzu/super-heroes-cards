package co.com.sofka.mongo.ronda;


import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.ronda.gateways.RondaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class RondaMongoRepositoryAdapter extends AdapterOperations<Ronda, RondaDocument, String, RondaMongoDBRepository>
implements RondaRepository {

    public RondaMongoRepositoryAdapter(RondaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Ronda.class));
    }


    @Override
    public Mono<Ronda> guardar(Ronda ronda) {
        return repository.save(new RondaDocument(
                        ronda.getId(),
                        ronda.getCronometro(),
                        ronda.getApuesta(),
                        ronda.getIdGanador()))
                .flatMap(rondaDocument -> Mono.just(ronda));
    }

    @Override
    public Flux<Ronda> listarTodasLasRondas() {
        return repository.findAll()
                .map(rondaDocument -> new Ronda(
                            rondaDocument.getId(),
                            rondaDocument.getCronometro(),
                            rondaDocument.getApuesta(),
                            rondaDocument.getIdGanador()
                    ));
    }

    @Override
    public Mono<Ronda> obtenerRondaPorId(String idRonda) {
        return repository.findById(idRonda)
                .map(rondaDocument -> new Ronda(
                        rondaDocument.getId(),
                        rondaDocument.getCronometro(),
                        rondaDocument.getApuesta(),
                        rondaDocument.getIdGanador()
                ));
    }

}
