package ar.edu.utn.frc.tup.lciii.model;


import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Turnero;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurneroTest {

    private Turnero turnero;
    Player j1;
    Player j2;
    Player j3;
    Player j4;

    @BeforeEach
    public void setUp() {
        Turnero.Initiative initiative = new Turnero.Initiative(0);

         j1 =new User("Raiden");
         j2 =new User("Eula");
         j3 =new User("Yelan");
         j4 =new User("Arlecchino");

        initiative.addPlayer(j1);
        initiative.addPlayer(j2);
        initiative.addPlayer(j3);
        initiative.addPlayer(j4);

        turnero = new Turnero(initiative, 0);
    }

    @Test
    public void testHasNext(){
        assertTrue(turnero.hasNext());

    }

    @Test
    public void testNext() {
        assertEquals("Raiden",turnero.next().getName() );
        assertEquals("Eula",turnero.next().getName() );
        assertEquals("Yelan",turnero.next().getName() );
        assertEquals("Arlecchino",turnero.next().getName() );
        assertEquals(0,turnero.getTurnPointer());
    }

    @Test
    public void testSpecialCases() {
        j2.setStill(true);
        j3.setLose(true);
        assertEquals("Raiden",turnero.next().getName() );
        assertNotEquals("Eula",turnero.next().getName() );
        assertNotEquals("Yelan",turnero.next().getName() );
        assertEquals("Arlecchino",turnero.next().getName() );
    }
    @Test
    public void testNext_SkipImmobilePlayers() {

        Turnero.Initiative initiative = new Turnero.Initiative(0);

        Player j1 = new User("Raiden");
        Player j2 = new User("Eula");
        j2.setStill(true);
        Player j3 = new User("Yelan");
        Player j4 = new User("Arlecchino");

        initiative.addPlayer(j1);
        initiative.addPlayer(j2);
        initiative.addPlayer(j3);
        initiative.addPlayer(j4);

        turnero = new Turnero(initiative, 0);

        assertEquals("Raiden", turnero.next().getName());
        assertEquals("Yelan", turnero.next().getName());
        assertEquals("Arlecchino", turnero.next().getName());
        assertEquals(0, turnero.getTurnPointer());
    }
    @Test
    public void testNext_RestartTurns() {
        assertEquals("Raiden", turnero.next().getName());
        assertEquals("Eula", turnero.next().getName());
        assertEquals("Yelan", turnero.next().getName());
        assertEquals("Arlecchino", turnero.next().getName());
        assertEquals("Raiden", turnero.next().getName());
    }

    @Test
    public void testNext_SkipPlayersWhoLost() {

        Turnero.Initiative initiative = new Turnero.Initiative(0);

        Player j1 = new User("Raiden");
        Player j2 = new User("Eula");
        j2.setLose(true);
        Player j3 = new User("Yelan");
        Player j4 = new User("Arlecchino");

        initiative.addPlayer(j1);
        initiative.addPlayer(j2);
        initiative.addPlayer(j3);
        initiative.addPlayer(j4);

        turnero = new Turnero(initiative, 0);

        assertEquals("Raiden", turnero.next().getName());
        assertEquals("Yelan", turnero.next().getName());
        assertEquals("Arlecchino", turnero.next().getName());
        assertEquals(0, turnero.getTurnPointer());
    }

}
