package ar.edu.utn.frc.tup.lciii.model;

import lombok.Getter;

@Getter

public abstract class Cell implements ar.edu.utn.frc.tup.lciii.services.Cell {
    private  String name;
    private int number;
    private String type;
    private boolean purchasable;


    public Cell(boolean purchasable, String type, int number, String name){

        this.purchasable = purchasable;
        this.type = type;
        this.name = name;
        this.number = number;
    }

    public abstract void PlayerEntered(Player pl1);

}
