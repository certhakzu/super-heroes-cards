package co.com.sofka.api.tarjeta;

import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.usecase.tarjeta.actualizartarjeta.ActualizarTarjetaUseCase;
import co.com.sofka.usecase.tarjeta.creartarjeta.CrearTarjetaUseCase;
import co.com.sofka.usecase.tarjeta.eliminartarjeta.EliminarTarjetaUseCase;
import co.com.sofka.usecase.tarjeta.listartarjetas.ListarTarjetasUseCase;
import co.com.sofka.usecase.tarjeta.obtenertarjetaporid.ObtenerTarjetaPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TarjetaHandler {

    private final CrearTarjetaUseCase crearTarjetaUseCase;
    private final EliminarTarjetaUseCase eliminarTarjetaUseCase;
    private final ActualizarTarjetaUseCase actualizarTarjetaUseCase;
    private final ListarTarjetasUseCase listarTarjetasUseCase;
    private final ObtenerTarjetaPorIdUseCase obtenerTarjetaPorIdUseCase;

    public Mono<ServerResponse> crearTarjeta(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Tarjeta.class) // Deberia ir un dto, pero vamos a pasar el model
                //.flatMap(tarjeta -> crearTarjetaUseCase.guardarTarjeta(tarjeta)) // flujo alterno para el proceso de almacenamiento
                .flatMap(tarjeta -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearTarjetaUseCase.guardarTarjeta(tarjeta), Tarjeta.class));
    }

    public Mono<ServerResponse> listarTarjetas(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(listarTarjetasUseCase.listarTarjetas(), Tarjeta.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> eliminarTarjeta(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(eliminarTarjetaUseCase.eliminarTarjeta(id), Tarjeta.class);
    }

    public Mono<ServerResponse> actualizarTarjeta(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Tarjeta.class)
                .flatMap(tarjeta -> crearTarjetaUseCase.guardarTarjeta(tarjeta))
                .flatMap(tarjeta -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(tarjeta));
    }

    public Mono<ServerResponse> obtenerTarjeta(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(obtenerTarjetaPorIdUseCase.obtenerTarjetaPorId(id), Tarjeta.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
