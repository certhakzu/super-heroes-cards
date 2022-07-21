package co.com.sofka.mongo;

import co.com.sofka.model.tarjeta.Tarjeta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<TarjetaDocument, String>, ReactiveQueryByExampleExecutor<TarjetaDocument> {
}
