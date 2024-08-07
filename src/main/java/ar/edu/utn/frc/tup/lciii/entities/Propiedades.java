package ar.edu.utn.frc.tup.lciii.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propiedades {
    private String nombre;
    private String provincia;
    private int precio_compra;
    private int precio_mejora;
    private int alquiler_base;
    private int alquiler_1chacra;
    private int alquiler_2chacra;
    private int alquiler_3chacra;
    private int alquiler_4chacra;
    private int alquiler_1estancia;
    private int valor_hipotecario;
    private int celda;

}
