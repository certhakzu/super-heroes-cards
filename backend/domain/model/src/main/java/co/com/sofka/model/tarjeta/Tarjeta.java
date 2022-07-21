package co.com.sofka.model.tarjeta;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Tarjeta {

    private String id;
    private String descripcion;
    private String caracteristicas;
    private Integer poder;
    private String urlImagen;
}
