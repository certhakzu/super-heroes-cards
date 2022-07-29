package co.com.sofka.mongo.jugador;

import co.com.sofka.model.mazo.Mazo;
import co.com.sofka.model.tarjeta.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDocument {
    @Id
    private String id;
    private String alias;
    private Integer puntos;
    private Mazo mazo;
    private Boolean esActivo;
}
