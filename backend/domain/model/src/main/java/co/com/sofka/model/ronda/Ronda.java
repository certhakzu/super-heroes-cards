package co.com.sofka.model.ronda;
import co.com.sofka.model.jugador.Jugador;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Ronda {
    private String id;
    private Integer cronometro;
    private Map<String, String> apuesta; // idJugador - idTarjeta
    private String idGanador;

}
