package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Bank;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Tablero;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class TarjetaMovimiento extends Card implements CardInterface {

    private int destiny;

    public TarjetaMovimiento(int destiny,String message) {
        super(message);
        this.destiny=destiny;
    }

    @Override
    public void effect(Player player) {

        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);

        if (destiny==3) {
            destiny= player.getPositionOnBoard()-3;
        }

        if (player.getPositionOnBoard()>destiny){
            Bank.giveMoney(player,5000);
        }

        player.setPositionOnBoard(destiny);

        Tablero.getInstance().getBoard().get(destiny).PlayerEntered(player);

        if (destiny==0){
            Bank.giveMoney(player,5000);
        }
    }
}
