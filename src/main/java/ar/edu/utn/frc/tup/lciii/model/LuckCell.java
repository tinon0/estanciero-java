package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LuckCell extends Cell {

    public LuckCell(boolean purchasable, String type, int number, String name) {
        super(purchasable, type, number, name);

    }
    @Override
    public void PlayerEntered(Player pl1) {
        Printer.println(pl1.getName() + " has entrado a una celda suerte, levanta un carta del mazo suerte. Numero de celda: " + this.getNumber());
    }
}
