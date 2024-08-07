package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.Bank;
import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import lombok.Getter;

@Getter
public class TarjetaPago  extends Card implements CardInterface {
    int money;
    public TarjetaPago(int money,String message) {
        super(message);
        this.money = money;
    }

    @Override
    public void effect(Player player) {
        Printer.println("el jugador "+ player.getName()+" acaba de levantar una carta:" );
        Printer.println(message);

        if (money==2500500||money==4000800) {
            money=500;
        }


        Bank.takeMoney(player,money);
    }
}
