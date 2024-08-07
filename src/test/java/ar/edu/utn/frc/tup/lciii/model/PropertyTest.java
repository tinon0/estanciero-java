package ar.edu.utn.frc.tup.lciii.model;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PropertyTest {
    @Test
    void testPlayerEntered_NoOwner() {
        Property property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "", null, false,0,0,0,0,0,0,0);
        Player player = new User("Player");

        property.PlayerEntered(player);
        assertFalse(property.isBusy());
    }

    @Test
    void testPlayerEntered_OwnerIsPlayer() {
        Property property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "", "Player", false,0,0,0,0,0,0,0);
        Player player = new User("Player");

        property.PlayerEntered(player);
        assertFalse(property.isBusy());
    }

    @Test
    void testPlayerEntered_OwnerIsDifferentPlayer() {
        Player playerOwner = new User("nombreLindo");
        Player player = new User("nombre");
        Property property = new Property(true, "tipo", 1, "nombre", 0, 0, 0, 0, "", "nombreLindo", false,0,0,0,0,0,0,0);
        Tablero tablero = Tablero.getInstance();
        List<Player> lista = new ArrayList<>();
        lista.add(player); lista.add(playerOwner);

        tablero.ordering(lista);
        playerOwner.getProperties().add(property);

        property.PlayerEntered(player);

    }


    @Test
    void cuantoVale() {
        Property property = new Property(true, "Type", 1, "Nombre", 0, 0, 2, 0, "", null, false,0,0,0,0,0,0,0);
        int resultado = property.calculateValue(2, 2);
        assertEquals(4, resultado);
    }

    @Test
    void pay() {
        Player playerOwner = new User("nombreLindo");
        Player player = new User("nombre");
        Property property = new Property(true, "tipo", 1, "nombre", 0, 0, 0, 0, "", "nombreLindo", false,0,0,0,0,0,0,0);
        Tablero tablero = Tablero.getInstance();
        List<Player> lista = new ArrayList<>();
        lista.add(player); lista.add(playerOwner);

        tablero.ordering(lista);
        playerOwner.getProperties().add(property);
        property.Pay(player, 1000);
        assertEquals(34000, player.getMoney());
    }

    @Test
    public void testCaluclateRent() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Property property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "", null, false,50,50,100,200,300,400,1000);

        Method calculateRentMethod = Property.class.getDeclaredMethod("calculateRent");
        calculateRentMethod.setAccessible(true);

        assertEquals(50,(int) calculateRentMethod.invoke(property));

        property.setChacras(1);
        assertEquals(100,(int) calculateRentMethod.invoke(property));

        property.setChacras(2);
        assertEquals(200,(int) calculateRentMethod.invoke(property));

        property.setChacras(3);
        assertEquals(300,(int) calculateRentMethod.invoke(property));

        property.setChacras(4);
        assertEquals(400,(int) calculateRentMethod.invoke(property));

        property.setResidence(1);
        assertEquals(1000,(int) calculateRentMethod.invoke(property));


    }
}
