package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jugadores {
    private int id_jugador;
    private String jugador_nombre;
    private int cant_victorias;
    private int cant_derrotas;
}
