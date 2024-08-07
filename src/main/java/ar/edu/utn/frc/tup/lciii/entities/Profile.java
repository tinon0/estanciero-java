package ar.edu.utn.frc.tup.lciii.entities;

import lombok.Data;

@Data
public class Profile {
    private String nombre;
    private int loses;
    private int wins;
    private int unfinished;

    public Profile(String name) {
        this.nombre=name;
        this.loses=0;
        this.wins=0;
    }
}
