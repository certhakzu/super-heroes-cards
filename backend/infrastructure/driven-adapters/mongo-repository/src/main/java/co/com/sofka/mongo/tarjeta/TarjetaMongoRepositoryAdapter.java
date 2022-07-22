package co.com.sofka.mongo.tarjeta;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.model.tarjeta.gateways.TarjetaRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TarjetaMongoRepositoryAdapter extends AdapterOperations<Tarjeta, TarjetaDocument, String, TarjetaMongoDBRepository>
implements TarjetaRepository {

    public TarjetaMongoRepositoryAdapter(TarjetaMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Tarjeta.class));
    }

    @Override
    public Mono<Tarjeta> guardar(Tarjeta tarjeta) {
        return repository.save(new TarjetaDocument(
                        tarjeta.getId(),
                        tarjeta.getDescripcion(),
                        tarjeta.getCaracteristicas(),
                        tarjeta.getPoder(),
                        tarjeta.getUrlImagen()))
                .flatMap(tarjetaDocument -> Mono.just(tarjeta));
    }

    @Override
    public Flux<Tarjeta> listarTarjetas() {
        return repository.findAll().map(tarjetaDocument -> new Tarjeta(
                tarjetaDocument.getId(),
                tarjetaDocument.getDescripcion(),
                tarjetaDocument.getCaracteristicas(),
                tarjetaDocument.getPoder(),
                tarjetaDocument.getUrlImagen()
        ));
    }
}
