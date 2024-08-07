package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Cell;

import ar.edu.utn.frc.tup.lciii.model.LuckCell;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.model.Deck;
import static org.junit.jupiter.api.Assertions.*;


public class FabricaCellSuerteTest {
    private FabricaCellSuerte fabrica;
    private  Deck d;
    private User pl1;



    @Test
    public void testCreateCell(){

        fabrica= new FabricaCellSuerte();
        //d = new Deck("Suerte");
        pl1= new User("test");
        Cell c = fabrica.createCell(true,"Suerte", 1,"0",0,0, 0, 0,null, "false", true, 0,0,0,0,0,0,0);
        assertNotNull(c);
        assertTrue(c instanceof LuckCell);

        assertEquals("Suerte", c.getType());
        assertEquals(1, c.getNumber());
    }

}
