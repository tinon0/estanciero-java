package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import lombok.Getter;

@Getter
public class TargetCell extends Cell {

    public TargetCell(boolean purchasable, String type, int number, String name) {
        super(purchasable, type, number, name);

    }

    @Override
    public void PlayerEntered(Player pl1) {
        Printer.println(pl1.getName() + " has entrado a una celda destino, levanta un carta del mazo destino. Numero de celda: " + this.getNumber());

    }
}
