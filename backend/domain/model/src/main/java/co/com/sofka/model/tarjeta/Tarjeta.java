package co.com.sofka.model.tarjeta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {

    private String id;
    private String descripcion;
    private String caracteristicas;
    private Integer poder;
    private String urlImagen;
    private Boolean esVisible;
}
