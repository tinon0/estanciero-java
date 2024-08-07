package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Turnero;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class InitiativeTest {
    private Turnero.Initiative initiative;

    @BeforeEach
    public void setUp() {
        initiative = new Turnero.Initiative(0);
    }

    @Test
    public void testAddPlayer() {
        assertEquals(0,initiative.getPlayerOrder().size());

        Player j1 =new User("Raiden");

        initiative.addPlayer(j1);

        assertTrue(initiative.getPlayerOrder().contains(j1));

        Player j2 =new User("Eula");

        initiative.addPlayer(j2);

        assertEquals(2, initiative.getPlayerOrder().size());
    }

    @Test
    public void testIterator() {
        Player j1 =new User("Raiden");
        Player j2 =new User("Eula");
        Player j3 =new User("Yelan");
        Player j4 =new User("Arlecchino");

        initiative.addPlayer(j1);
        initiative.addPlayer(j2);
        initiative.addPlayer(j3);
        initiative.addPlayer(j4);

        Iterator<Player> it = initiative.iterator();

        assertNotNull(it);
    }
}
