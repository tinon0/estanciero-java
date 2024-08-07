package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaSalirComisaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaSalirComisariaTest {
    private Player player;
    private CardInterface card;

    @BeforeEach
    public void setup(){
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        card=new TarjetaSalirComisaria("mensaje");
    }

    @Test
    public void TestEffect() {
        card.effect(player);

        assertEquals(1,player.getTarjetasSalirComisaria());
    }
}
