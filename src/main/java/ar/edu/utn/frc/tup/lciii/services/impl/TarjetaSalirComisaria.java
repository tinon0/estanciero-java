package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class TarjetaSalirComisaria extends Card implements CardInterface {


    public TarjetaSalirComisaria(String message) {
        super(message);
    }

    @Override
    public void effect(Player player) {

        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);



        int plus = player.getTarjetasSalirComisaria() + 1;

        player.setTarjetasSalirComisaria(plus);
    }
}
