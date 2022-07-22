package co.com.sofka.usecase.jugador.listarjugadores;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.jugador.gateways.JugadorRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListarJugadoresUseCase {
    private JugadorRepository repository;

    public Flux<Jugador> listarJugadores(){
        return repository.listarTodosLosJugador();
    }
}
