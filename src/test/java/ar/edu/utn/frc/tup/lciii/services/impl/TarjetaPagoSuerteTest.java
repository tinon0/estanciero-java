package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaPagoSuerte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaPagoSuerteTest {
    private Player player;
    private CardInterface card;



    @Test
    public void TestEffect() {
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        card=new TarjetaPagoSuerte(50,"");
        card.effect(player);

        assertEquals(50,player.getMoney());
    }
}
