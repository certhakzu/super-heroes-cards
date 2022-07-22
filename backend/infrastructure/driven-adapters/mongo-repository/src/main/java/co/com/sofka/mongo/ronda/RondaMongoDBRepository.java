package co.com.sofka.mongo.ronda;

import co.com.sofka.mongo.tarjeta.TarjetaDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface RondaMongoDBRepository extends ReactiveMongoRepository<RondaDocument, String>, ReactiveQueryByExampleExecutor<RondaDocument> {
}
