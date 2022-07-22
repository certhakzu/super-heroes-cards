package co.com.sofka.mongo.tarjeta;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface TarjetaMongoDBRepository extends ReactiveMongoRepository<TarjetaDocument, String>, ReactiveQueryByExampleExecutor<TarjetaDocument> {
}
