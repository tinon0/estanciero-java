package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Bank;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Tablero;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class TarjetaCobrar extends Card implements CardInterface {

    private int money;


    public TarjetaCobrar(int money, String message) {
        super(message);
        this.money=money;

    }

    @Override
    public void effect(Player player) {

        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);
        if (money==200) {
            int numJugadores = Tablero.getInstance().getPlayerOrder().size();
            money = (numJugadores-1)*200;
        }


        Bank.giveMoney(player,money);
    }
}
