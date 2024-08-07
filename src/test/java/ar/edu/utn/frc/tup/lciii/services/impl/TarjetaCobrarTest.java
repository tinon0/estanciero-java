package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.HandlerPartida;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarjetaCobrarTest {
    private Player player;
    private CardInterface card;

    private HandlerPartida handlerPartida;
    private Scanner mockScaner;



    @Test
    public void TestEffect() {
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        card=new TarjetaCobrar(50, "message");
        card.effect(player);

        assertEquals(150,player.getMoney());
    }

    @Test
    public void testSpecialCases(){
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        card=new TarjetaCobrar(50, "message");
        Card card1 = new TarjetaCobrar(200, "message");

        mockScaner = mock(Scanner.class);
        when(mockScaner.nextLong()).thenReturn(100000L);
        when(mockScaner.nextInt()).thenReturn(1);
        handlerPartida = new HandlerPartida(mockScaner);

        card1.effect(player);
        assertEquals(500,player.getMoney());
    }


}
