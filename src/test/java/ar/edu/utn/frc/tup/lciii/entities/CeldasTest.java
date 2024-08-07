package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Celdas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldasTest {

    @Test
    void getId_celda() {
        Celdas celdas = new Celdas();
        celdas.setId_celda(1);
        assertEquals(1, celdas.getId_celda());
    }

    @Test
    void getId_tipo_celda() {
        Celdas celdas = new Celdas();
        celdas.setTipo_celda(10);
        assertEquals(10, celdas.getTipo_celda());
    }

    @Test
    void setId_celda() {
        Celdas celdas = new Celdas();
        celdas.setId_celda(2);
        assertEquals(2, celdas.getId_celda());
    }

    @Test
    void setId_tipo_celda() {
        Celdas celdas = new Celdas();
        celdas.setTipo_celda(20);
        assertEquals(20, celdas.getTipo_celda());
    }
}