package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GameData {
    List<Celdas> celdas;
    List<Posesiones> posesiones;
    List<Propiedades> propiedades;
    List<Tarjetas> tarjetas;
}
