package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Bank;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void giveMoney(){
        Bank bank = new Bank();
        Player player = new User("NOMBRE");
        bank.giveMoney(player, 18);
        assertEquals(35018, player.getMoney());
    }
    @Test
    void takeMoney(){
        Bank bank = new Bank();
        Player player = new User("NOMBRE");
        bank.takeMoney(player, 1000);

        assertEquals(34000, player.getMoney());
    }
}