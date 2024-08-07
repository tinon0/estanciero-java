package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Tablero;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class TarjetaMarchePreso extends Card implements CardInterface {
    public TarjetaMarchePreso(String message) {
        super(message);
    }

    @Override
    public void effect(Player player) {

        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);

        player.setPositionOnBoard(14);

        Tablero.getInstance().getBoard().get(14).PlayerEntered(player);
    }
}
