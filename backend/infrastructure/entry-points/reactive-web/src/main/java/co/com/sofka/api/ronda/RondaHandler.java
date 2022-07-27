package co.com.sofka.api.ronda;



import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.usecase.ronda.crearronda.CrearRondaUseCase;
import co.com.sofka.usecase.ronda.listarrondas.ListarRondasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RondaHandler {
    private final CrearRondaUseCase crearRondaUseCase;
    private final ListarRondasUseCase listarRondasUseCase;

    // guardar ronda
    public Mono<ServerResponse> crearRonda(ServerRequest serverRequest){
        return  serverRequest.bodyToMono(Ronda.class)
                .flatMap(ronda -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(crearRondaUseCase.crearRonda(ronda), Ronda.class));
    }

    // listar rondas
    public Mono<ServerResponse> listarRondas(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listarRondasUseCase.listarRondas(), Ronda.class);
    }
}
