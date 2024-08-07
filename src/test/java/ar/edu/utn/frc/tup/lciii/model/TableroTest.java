package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.entities.GameData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class TableroTest {

    private Tablero tablero;
    private GameData gameData;


    @BeforeEach
    public void setUp() {
        tablero = Tablero.getInstance();
        tablero.setDificulty(3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileReader reader =  new FileReader("GameData.json")){
            gameData = gson.fromJson(reader, GameData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testTablero() {
        assertNotNull(tablero);
        assertNotNull(tablero.getBoard());

    }

    @Test
    public void testMoverJugador() {

        User user1 = new User("Raiden");

        tablero.moverJugador(user1);

        assertTrue(user1.getPositionOnBoard()>1&&user1.getPositionOnBoard()<13);
    }


    @Test
    public void testLlenarTablero(){
        tablero.llenarTablero(gameData);
        assertNotNull(gameData, "gameData no deberia ser nulo" );
        Map<Integer, Cell> board = tablero.getBoard();
        assertEquals(42, board.size(), "el tablero deberia tener 41 celdas");
        Cell cell1 = board.get(1);
        assertNotNull(cell1, "Celda no deberia ser nula");
        assertEquals("Propiedad", cell1.getType());
        Cell cell2 = board.get(2);
        assertNotNull(cell2, "Celda 2 no deberia ser nula");
        assertEquals("Propiedad", cell2.getType());
        Cell cell8 = board.get(8);
        assertNotNull(cell8, "Celda 8 no debe ser nula");
        assertEquals("Company", cell8.getType());

    }

    @Test
    public void testPlayerOrdering() {
        User user1 = new User("Raiden");
        User user2 = new User("Arlecchino");
        User user3 = new User("Eula");

        List<Player> players = List.of(user1, user2, user3);

        List<Player> order = tablero.ordering(players);

        assertEquals(user1.getMoney(), order.get(0).getMoney());
        assertEquals(user2.getMoney(), order.get(1).getMoney());
    }
    @Test
    public void testCell42(){
        Cell cell = tablero.obtenerCasilla(42);
        assertNull(cell);
    }
}
