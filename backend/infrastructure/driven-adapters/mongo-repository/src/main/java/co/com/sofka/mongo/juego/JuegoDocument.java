package co.com.sofka.mongo.juego;

import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.ronda.Ronda;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoDocument {
    @Id
    private String id;
    private Set<Tarjeta> baraja;
    private Set<Ronda> rondas;
    private Set<Jugador> jugadores;
    private String idGanador;
}
