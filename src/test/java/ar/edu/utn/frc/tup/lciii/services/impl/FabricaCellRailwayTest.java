package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Cell;
import ar.edu.utn.frc.tup.lciii.model.Railway;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaCellRailwayTest {
    private FabricaCellRailway fabrica;
    @Test
    public  void TestCreateCell(){
        fabrica = new FabricaCellRailway();
        Cell c = fabrica.createCell(true,"Railway",2, "2000",0, 0, 2000 ,0, null, "false", true, 0,0,0,0,0,0,0 );
        assertNotNull(c);
        assertTrue(c instanceof Railway);
        assertEquals("Railway", c.getType());
        assertEquals(2, c.getNumber());
        Railway railway = (Railway) c;
        assertEquals(2000, railway.getValue());
    }
}
