package co.com.sofka.model.juego.gateways;

import co.com.sofka.model.juego.Juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tarjeta.Tarjeta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.annotation.Target;
import java.util.Set;

public interface JuegoRepository {
    Mono<Juego> guardar(Juego juego);
    Mono<Juego> eliminarJuego(String id);
    Mono<Juego> actualizarJuego(String id, Juego juego);
    Flux<Juego> listarTodosLosJuegos();

    // repartir cartas
    Flux<Tarjeta> repartirCartas(Short numeroDeJugadores);
    // validar usuario
    Mono<Boolean> validarJugador(Jugador jugador);
}
