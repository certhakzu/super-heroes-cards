package co.com.sofka.model.juego;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author Piter Velasquez
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Juego {
    private String id;
    private Set<Tarjeta> baraja; // contiene los id de las tarjetas
    private Set<Ronda> rondas; // contiene los id de las rondas de este juego
    private Set<Jugador> jugadores; // contiene los id de los jugadores habilitados para jugar este juego
    private String idGanador;

}
