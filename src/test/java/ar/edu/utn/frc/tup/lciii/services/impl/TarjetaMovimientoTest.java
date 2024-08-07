package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.*;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaMovimiento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaMovimientoTest {
    private Player player;
    private CardInterface card;
    private Tablero tablero;

    @BeforeEach
    public void setup(){
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        tablero = Tablero.getInstance();

        for (int i = 0; i < 15; i++) {
            Cell cell = new Railway(true,"mock",i,"mock",2000,"Raiden");

            tablero.getBoard().put(i,cell);
        }

        card=new TarjetaMovimiento(5,"");
    }

    @Test
    public void TestEffect() {
        card.effect(player);

        assertEquals(5,player.getPositionOnBoard());
    }

    @Test
    public void testSpecialCases(){
        player.setPositionOnBoard(5);
        Card backCard = new TarjetaMovimiento(3,"");
        backCard.effect(player);

        assertEquals(2,player.getPositionOnBoard());
        Card exitCard = new TarjetaMovimiento(0,"");
        exitCard.effect(player);
        assertEquals(15100,player.getMoney());


    }
}
