package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.entities.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProfileManagerTest {
    private ProfileManager profileManager;

    private HandlerPartida handlerPartida;
    private Scanner mockScaner;

    @BeforeEach
    public void setUp() {
        profileManager = new ProfileManager();
    }

    @Test
    public void testDisplay() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String input = "1\n";
        InputStream inputStream= new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);


        Method displayMethod = ProfileManager.class.getDeclaredMethod("display");
        displayMethod.setAccessible(true);

        int choice = (int) displayMethod.invoke(profileManager);

        assertEquals(1,choice);
    }

    @Test
    public void testMenuSelectOldProfile() {
        String input = "2\n1\n";
        InputStream inputStream= new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Profile selected = profileManager.selectProfileMenu();
        assertEquals("salome",selected.getNombre());
    }

    @Test
    public void testMenuNewProfile() {
        String input = "1\nSnake\n";
        InputStream inputStream= new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Profile selected = profileManager.selectProfileMenu();
        assertEquals("Snake",selected.getNombre());
    }
    @Test
    public void testSaveData() {
        String input = "2\n1\n";
        InputStream inputStream= new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Profile selected = profileManager.selectProfileMenu();

        mockScaner = mock(Scanner.class);
        when(mockScaner.nextLine()).thenReturn("silverPlate");
        when(mockScaner.nextLong()).thenReturn(100000L);
        when(mockScaner.nextInt()).thenReturn(1);
        handlerPartida = new HandlerPartida(mockScaner);



        profileManager.saveGame(handlerPartida,selected);

    }
}
