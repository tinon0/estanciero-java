package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Cell;
import ar.edu.utn.frc.tup.lciii.model.Deck;
import ar.edu.utn.frc.tup.lciii.model.TargetCell;
import ar.edu.utn.frc.tup.lciii.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaCellTargetTest {
    private FabricaCellTarget fabrica;
    private Deck d;
    private User pl1;
    @Test
    public void testCreateCell(){

        fabrica= new FabricaCellTarget();
        //d = new Deck("Destino");
        pl1= new User("test");
        Cell c = fabrica.createCell(true,"Destino", 1,"0",0,0, 0, 0,null, "false", true, 0,0,0,0,0,0,0);
        assertNotNull(c);
        assertTrue(c instanceof TargetCell);

        assertEquals("Destino", c.getType());
        assertEquals(1, c.getNumber());
    }
}
