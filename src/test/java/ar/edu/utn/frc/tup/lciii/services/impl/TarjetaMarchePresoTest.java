package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.*;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaMarchePreso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarjetaMarchePresoTest {
    private Player player;
    private CardInterface card;
    private Tablero tablero;


    @Test
    public void TestEffect() {
        player= new User("Raiden");
        player.setMoney(100);
        player.setPositionOnBoard(0);

        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);


        for (int i = 0; i < 15; i++) {
           Railway railway = new Railway (true,"mock",i,"mock",3000, "Raiden");

            Cell cell = railway;

            tablero.getBoard().put(i,cell);
            player.getRailways().add(railway);
            railway.PlayerEntered(player);

        }

        card=new TarjetaMarchePreso("");
        card.effect(player);

        assertEquals(14,player.getPositionOnBoard());
    }
}
