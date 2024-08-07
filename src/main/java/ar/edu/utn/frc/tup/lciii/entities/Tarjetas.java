package ar.edu.utn.frc.tup.lciii.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarjetas {
    private String mensaje;
    private int effecto_modificador;
    private int id_tipo_efecto;
    private String tipo_tarjeta;
}
