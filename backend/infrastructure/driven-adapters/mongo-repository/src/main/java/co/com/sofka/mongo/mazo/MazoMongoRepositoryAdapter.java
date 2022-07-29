package co.com.sofka.mongo.mazo;

import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.mazo.gateways.MazoRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Repository
public class MazoMongoRepositoryAdapter extends AdapterOperations<Mazo, MazoDocument, String, MazoMongoDBRepository>
implements MazoRepository {

    public MazoMongoRepositoryAdapter(MazoMongoDBRepository repository, ObjectMapper mapper, Function<MazoDocument, Mazo> toEntityFn) {
        super(repository, mapper, d -> mapper.map(d, Mazo.class));
    }

    @Override
    public Mono<Mazo> guardar(Mazo mazo) {
        return repository.save(new MazoDocument(mazo.getId(), mazo.getTarjetas()))
                .flatMap(mazoDocument -> Mono.just(mazo));
    }

    @Override
    public Flux<Mazo> listarTodos() {
        return repository.findAll()
                .map(mazoDocument -> new Mazo(mazoDocument.getId(), mazoDocument.getTarjetas()));
    }
}
