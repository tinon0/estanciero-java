package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposEfectos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposEfectosTest {

    @Test
    void getId_tipo_efecto() {
        TiposEfectos tipo = new TiposEfectos();
        tipo.setId_tipo_efecto(1);
        assertEquals(1, tipo.getId_tipo_efecto());
    }

    @Test
    void getDescripcion() {
        TiposEfectos tipo = new TiposEfectos();
        tipo.setDescripcion("Sustraer Dinero");
        assertEquals("Sustraer Dinero", tipo.getDescripcion());
    }
}