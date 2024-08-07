package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Company;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyTest {
    @Test
    void testPlayerEntered_NoOwner() {
        Company company = new Company(true, "Type", 1, "Nombre", 0, null);
        Player player = new User("Player");

        company.PlayerEntered(player);
    }

    @Test
    void testPlayerEntered_OwnerIsPlayer() {
        Company company = new Company(true, "Type", 1, "Nombre", 0, "Player");
        Player player = new User("Player");

        company.PlayerEntered(player);
    }

    @Test
    void testPlayerEntered_OwnerIsDifferentPlayer() {
        Company company = new Company(true, "Type", 1, "Nombre", 0, "OtherPlayer");
        Tablero tablero = Tablero.getInstance();

        Player player = new User("Player");
        Player playerowner= new User("OtherPlayer");
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(playerowner);
        tablero.ordering(players);

        company.PlayerEntered(player);
    }

    @Test
    void pay() {
        Player player = new User("Player");
        Player playerOwner = new User("OtherPlayer");
        Company company = new Company(true, "tipo", 1, "name", 1, playerOwner.getName());


        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(playerOwner);
        tablero.ordering(players);

        playerOwner.getCompanies().add(company);
        
        company.Pay(player);

        assertTrue(player.getMoney() < 35000);
        assertTrue(36200 >= playerOwner.getMoney());
    }
}