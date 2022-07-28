package co.com.sofka.api.ronda;



import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.usecase.ronda.crearronda.CrearRondaUseCase;
import co.com.sofka.usecase.ronda.dartarjetasalganador.DarTarjetasAlGanadorDeRondaUseCase;
import co.com.sofka.usecase.ronda.definirganadroderonada.DefinirGanadorDeRondaUseCase;
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
    private final DefinirGanadorDeRondaUseCase definirGanadorDeRondaUseCase;
    private final DarTarjetasAlGanadorDeRondaUseCase darTarjetasAlGanadorDeRondaUseCase;


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

    public Mono<ServerResponse> definirGanadorDeRonda(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(definirGanadorDeRondaUseCase.definirGanadorDeRonda(id), Ronda.class);
    }

    public Mono<ServerResponse> darTarjetasAlGanadorDeRonda(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(darTarjetasAlGanadorDeRondaUseCase.darTarjetasAlGanadorDeRonda(id), Tarjeta.class);
    }

}
