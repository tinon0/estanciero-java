package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Cell;
import ar.edu.utn.frc.tup.lciii.model.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaCellPropertyTest {
        private FabricaCellProperty fabrica;
        @Test
        public  void TestCreateCell(){
            fabrica = new FabricaCellProperty();
            Cell c = fabrica.createCell(true, "Property",2, "2000",1, 0, 2000 ,300, "Entre Rios", "false", false, 0, 0,0,0,0,0,0);
            assertNotNull(c);
            Property property = (Property) c;
            assertTrue(c instanceof Property);
            assertEquals("Property", c.getType());
            assertEquals(1, property.getChacras() );
            assertEquals(0, property.getResidence());
            assertEquals(300, property.getMortgageValue());
            assertEquals("Entre Rios", property.getProvince());
            assertFalse(property.isBusy());
            assertEquals(2, c.getNumber());

            assertEquals(2000, property.getValue());
        }

}
