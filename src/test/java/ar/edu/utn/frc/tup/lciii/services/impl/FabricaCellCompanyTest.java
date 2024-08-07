package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Cell;
import ar.edu.utn.frc.tup.lciii.model.Company;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FabricaCellCompanyTest {
    private FabricaCellCompany fabrica;


     @Test
        public  void TestCreateCell(){
        fabrica = new FabricaCellCompany();
         Cell c = fabrica.createCell(true, "Company", 2, "Nombre", 0,0,5000,0,null,null,false, 0,0,0,0,0,0,0);
         assertNotNull(c);
         assertTrue(c instanceof Company);
         assertEquals("Company", c.getType());
         assertEquals(2, c.getNumber());
         Company com = (Company) c;
        assertEquals(5000, com.getValue());
        }

}

