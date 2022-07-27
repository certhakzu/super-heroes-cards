package co.com.sofka.model.juego;

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
    private Set<String> baraja; // contiene los id de las tarjetas
    private Set<String> rondas; // contiene los id de las rondas de este juego
    private Set<String> jugadores; // contiene los id de los jugadores habilitados para jugar este juego
}
