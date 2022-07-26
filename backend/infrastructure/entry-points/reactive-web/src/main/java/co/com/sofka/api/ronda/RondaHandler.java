package co.com.sofka.api.ronda;



import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import co.com.sofka.usecase.ronda.crearronda.CrearRondaUseCase;
import co.com.sofka.usecase.ronda.devolvertarjetasapostadas.DevolverTarjetasApostadasUseCase;
import co.com.sofka.usecase.ronda.definirganadroderonada.DefinirGanadorDeRondaUseCase;
import co.com.sofka.usecase.ronda.establecerapuesta.EstablecerApuestaUseCase;
import co.com.sofka.usecase.ronda.listarrondas.ListarRondasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RondaHandler {
    private final CrearRondaUseCase crearRondaUseCase;
    private final ListarRondasUseCase listarRondasUseCase;
    private final DefinirGanadorDeRondaUseCase definirGanadorDeRondaUseCase;
    private final DevolverTarjetasApostadasUseCase devolverTarjetasApostadasUseCase;
    private final EstablecerApuestaUseCase establecerApuestaUseCase;



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

    public Mono<ServerResponse> devolverTarjetasApostadas(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(devolverTarjetasApostadasUseCase.devolverTarjetasApostadas(id), Tarjeta.class);
    }

    public Mono<ServerResponse> establecerApuesta(ServerRequest serverRequest){
        var idRonda = serverRequest.pathVariable("id");
        class Apuesta{
            Map<String, Tarjeta> casesJugadores;
        }
        return serverRequest
                .bodyToMono(Apuesta.class)
                .flatMap(apuesta -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(establecerApuestaUseCase.establecerApuesta(idRonda, (Map<String, Tarjeta>) apuesta), Ronda.class));
    }

}
