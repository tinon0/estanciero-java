package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Especial extends Cell {
    private int idCelda;

    public Especial(int idCelda,boolean purchasable, String type, int number, String name ) {
        super(purchasable,type,number,name);
        this.idCelda=idCelda;
    }

    @Override
    public void PlayerEntered(Player pl1) {
        if (idCelda==0) {
            Printer.println(pl1.getName()+" paso por la salida y se le otorgo 5000$");
        }
        if (idCelda==7){
            Printer.println(pl1.getName()+" cayo en premio y se le otorgo 2500$");
            Bank.giveMoney(pl1,2500);
        }
        if (idCelda==31){
            Printer.println(pl1.getName()+" cayo en la celda de impuestos a las ganancias, y tiene que pagar 5000$");
            Bank.takeMoney(pl1,5000);
        }
        if (idCelda==41){
            Printer.println(pl1.getName()+" cayo en la celda de impuestos a las ventas, y tiene que pagar 2000$");
            Bank.takeMoney(pl1,2000);
        }
        if (idCelda==14) {
            Printer.println(pl1.getName()+" Cayo preso en la comisaria");
            pl1.getOutOfJailCard();
        }
        if (idCelda==35) {
            Printer.println(pl1.getName()+" cometio un horrible crimen de evasion de impuestos a la comisaria!");
            pl1.setPositionOnBoard(14);
            Tablero.getInstance().getBoard().get(14).PlayerEntered(pl1);
        }
        if (idCelda==28) {
            Printer.println(pl1.getName()+" cayo en libre estacionamiento, osea no se hace nada");
        }
        if (idCelda==21) {
            Printer.println(pl1.getName()+" cayo en la casilla descanso, puede optar por esperar dos turnos o no");
        }

    }
}
