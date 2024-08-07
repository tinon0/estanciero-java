package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidasGuardadas {
    private int id_detalle;
    private int id_partida;
    private String jugador;
    private int id_tipo_jugador;
    private int dinero;
    private int orden_turnos;
}
