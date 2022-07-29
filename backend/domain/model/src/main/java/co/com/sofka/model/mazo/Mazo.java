package co.com.sofka.model.mazo;

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
public class Mazo {

    private String id;
    private Set<Tarjeta> tarjetas;

    public Mazo(Set<Tarjeta> tarjetas){
        this.tarjetas = tarjetas;
    }
}
