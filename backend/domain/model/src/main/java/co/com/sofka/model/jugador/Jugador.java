package co.com.sofka.model.jugador;
import co.com.sofka.model.mazo.Mazo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {
    private String id;
    private String alias;
    private Integer puntos;
    private Mazo mazo;
    private Boolean esActivo;

    public Jugador(String id, String alias, Boolean esActivo){
        this.id = id;
        this.alias = alias;
        this.esActivo = esActivo;
    }
}
