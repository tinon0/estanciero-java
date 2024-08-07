package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Provincias;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProvinciasTest {

    @Test
    void getId_provincia() {
        Provincias provincias = new Provincias();
        provincias.setId_provincia(1);
        assertEquals(1, provincias.getId_provincia());
    }

    @Test
    void getDescripcion() {
        Provincias provincias = new Provincias();
        provincias.setDescripcion("Cordoba");
        assertEquals("Cordoba", provincias.getDescripcion());
    }

}