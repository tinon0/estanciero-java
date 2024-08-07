package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaPago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaPagoTest {
    private Player player;
    private CardInterface card;

    @BeforeEach
    public void setup(){
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        card=new TarjetaPago(50,"");
    }

    @Test
    public void TestEffect() {
        card.effect(player);

        assertEquals(50,player.getMoney());
    }

    @Test
    public void testSpecialCases(){
        Card awful = new TarjetaPago(2500500,"fuck this shit man");
        player.setMoney(1000);
        awful.effect(player);
        assertEquals(500,player.getMoney());
    }
}
