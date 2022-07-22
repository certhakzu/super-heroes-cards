package co.com.sofka.model.juego;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Juego {
    private String id;
    private Set<Tarjeta> baraja;
    private Set<Ronda> rondas;
    private Set<Jugador> jugadores;
}