package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Bank;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class TarjetaPagoSuerte extends Card implements CardInterface {
    private int pagoSuerte;

    public TarjetaPagoSuerte(int pago,String message) {
        super(message);
        pagoSuerte = pago;
    }

    @Override
    public void effect(Player player) {
        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);

        Bank.takeMoney(player,pagoSuerte);
    }
}
