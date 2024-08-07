package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetallePartidas {
    private int id_partida;
    private String  nombre_partida;
    private int id_jugador;
    private int id_tipo_modo;
    private int ultimo_turno;
    private int valor_ganar;
}
