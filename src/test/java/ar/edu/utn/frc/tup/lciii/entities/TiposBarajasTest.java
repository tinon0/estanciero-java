package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposBarajas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposBarajasTest {

    @Test
    void getId_tipo_baraja() {
        TiposBarajas tipo = new TiposBarajas();
        tipo.setId_tipo_baraja(3);
        assertEquals(3, tipo.getId_tipo_baraja());
    }

    @Test
    void getTipo() {
        TiposBarajas tipo = new TiposBarajas();
        tipo.setTipo("Tipo");
        assertEquals("Tipo", tipo.getTipo());
    }
}