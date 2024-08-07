package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Railway;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RailwayTest {
    @Test
    void TestPlayerEntered(){
        Railway railway =new Railway(true, "type", 1, "trenes argentinos",3000,"Raiden");
        Player player = new User("Lisa");
        Player playerOwner = new User("Raiden");
        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(playerOwner);
        tablero.ordering(players);
        playerOwner.getRailways().add(railway);

        railway.PlayerEntered(player);
    }
    @Test
    void testPlayerEntered_NoOwner(){
        Railway railway =new Railway(true, "type", 1, "trenes argentinos",3000,null);
        Player player = new User("Lisa");
        railway.PlayerEntered(player);
    }
    @Test
    void testPlayerEntered_OwnerIsPlayer(){
        Railway railway =new Railway(true, "type", 1, "trenes argentinos",3000,"Lisa");
        Player player = new User("Lisa");
        railway.PlayerEntered(player);
    }
    @Test
    public void testPay() {
        Player player = new User("Test");
        Player playerOwner = new User("Raiden");
        Railway railway = new Railway(true, "tipo", 1, "nombre", 2000,"Raiden");
        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(playerOwner);
        tablero.ordering(players);
        playerOwner.getRailways().add(railway);

        railway.Pay(player);
        assertEquals(34500, player.getMoney());
    }
    @Test
    public void testPay_TwoRailway() {
        Player player = new User("Test");
        Player playerOwner = new User("Raiden");
        Railway railway = new Railway(true, "tipo", 1, "nombre", 2000,"Raiden");
        Railway railway2 = new Railway(true, "tipo", 1, "nombre", 2000,"Raiden");
        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(playerOwner);
        tablero.ordering(players);
        playerOwner.getRailways().add(railway);
        playerOwner.getRailways().add(railway2);
        railway.Pay(player);
        assertEquals(34000, player.getMoney());
    }


}
