package ar.edu.utn.frc.tup.lciii.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EspecialesTest {
    private Especial especial;

    private Player player;





    @Test
    public void testPlayerEnteredSalida() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(0);
        especial.PlayerEntered(player);
        assertEquals(35000,player.getMoney());
    }

    @Test
    public void testPlayerEnteredPremio() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(7);
        especial.PlayerEntered(player);
        assertEquals(35000+2500,player.getMoney());

    }

    @Test
    public void testPlayerEnteredImpuestoGanancias() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(31);
        especial.PlayerEntered(player);

        assertEquals(35000-5000,player.getMoney());

    }

    @Test
    public void testPlayerEnteredImpuestoVentas() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(41);
        especial.PlayerEntered(player);
        assertEquals(35000-2000,player.getMoney());
    }

    @Test
    public void testPlayerEnteredComisaria() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(14);
        especial.PlayerEntered(player);
    }
    
    @Test //TO DO Ver por que el player sigue siendo nulo
    public void testPlayerEnteredMarchaPreso() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Raiden");



        Tablero tablero = Tablero.getInstance();
        List<Player> players = new ArrayList<>();
        players.add(player);
        tablero.ordering(players);
        Railway railway =new Railway(true, "", 1, "", 1, "Raiden");

        player.getRailways().add(railway);
        railway.PlayerEntered(player);
        especial.setIdCelda(35);
        especial.PlayerEntered(player);
        assertEquals(14,player.getPositionOnBoard());


    }

    @Test
    public void testPlayerEnteredLibreEstacionamiento() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(28);
        especial.PlayerEntered(player);
    }

    @Test
    public void testPlayerEnteredDescanso() {
        especial = new Especial(0,false,"test",0,"test");
        player = new User("Calistro");
        especial.setIdCelda(21);
        especial.PlayerEntered(player);

    }
}
