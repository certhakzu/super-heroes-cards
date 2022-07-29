package co.com.sofka.mongo.ronda;


import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RondaDocument {
    @Id
    private String id;
    private Integer cronometro;
    private Map<String, Tarjeta> apuesta; // idJugador - idTarjeta
    private String idGanador;
}
