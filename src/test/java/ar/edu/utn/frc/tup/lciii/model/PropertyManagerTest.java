package ar.edu.utn.frc.tup.lciii.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyManagerTest {
    private PropertyManager propertyManager;

    @BeforeEach
    public void setUp(){
        propertyManager= PropertyManager.getInstance();
        propertyManager.getAllProperties().clear();
    }
    @Test
    public void testSigletonInstance(){
        PropertyManager instance1 =PropertyManager.getInstance();
        PropertyManager instance2 =PropertyManager.getInstance();
        assertSame(instance2, instance1);


    }
    @Test
    public void testAddProperty(){
        Property property = new Property(true,"property",6,"zona sur",0, 0 , 5700,0, "Formosa", null, false,0,0,0,0,0,0,0);
        Property property2 = new Property(true,"property",6,"zona sur",0, 0 , 5700,0 ,"Formosa", null, false,0,0,0,0,0,0,0);
        propertyManager.addProperty(property);
        propertyManager.addProperty(property2);
        List<Property> propertyList = propertyManager.getAllProperties();
        assertEquals(2, propertyList.size());
        assertTrue(propertyList.contains(property));
        assertTrue(propertyList.contains(property2));

    }
}
