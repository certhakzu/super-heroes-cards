package co.com.sofka.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class TarjetaDocument {
    @Id
    private String id;
    private String descripcion;
    private String caracteristicas;
    private Integer poder;
    private String urlImagen;
}
