package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposModos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposModosTest {

    @Test
    void getId_tipo_modo() {
        TiposModos tipo = new TiposModos();
        tipo.setId_tipo_modo(1);
        assertEquals(1, tipo.getId_tipo_modo());
    }

    @Test
    void getDescripcion() {
        TiposModos tipo = new TiposModos();
        tipo.setDescripcion("Modo Dificil");
        assertEquals("Modo Dificil", tipo.getDescripcion());
    }
}