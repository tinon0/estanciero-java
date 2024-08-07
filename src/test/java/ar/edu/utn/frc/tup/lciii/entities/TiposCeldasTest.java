package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposCeldas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposCeldasTest {

    @Test
    void getId_tipo_celda() {
        TiposCeldas tipo = new TiposCeldas();
        tipo.setId_tipo_celda(4);
        assertEquals(4, tipo.getId_tipo_celda());
    }

    @Test
    void getDescripcion() {
        TiposCeldas tipo = new TiposCeldas();
        tipo.setDescripcion("Descripcion");
        assertEquals("Descripcion", tipo.getDescripcion());
    }
}