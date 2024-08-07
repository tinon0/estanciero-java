package ar.edu.utn.frc.tup.lciii.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Posesiones {
    private String nombre;
    private int precio_compra;
    private int celda;
}
