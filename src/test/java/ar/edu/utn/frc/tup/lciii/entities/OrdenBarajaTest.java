package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.OrdenBaraja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdenBarajaTest {
    private OrdenBaraja ob;

    @BeforeEach
    void setUp() {
        ob = new OrdenBaraja();
        ob.setId(1);
        ob.setOrden(10);
        ob.setId_partida(100);
        ob.setId_tarjeta(1000);
        ob.setId_tipo_baraja(2);
    }

    @Test
    void getId() {
        assertEquals(1, ob.getId());
    }

    @Test
    void getId_partida() {
        assertEquals(100, ob.getId_partida());
    }

    @Test
    void getId_tipo_baraja() {
        assertEquals(2, ob.getId_tipo_baraja());

    }

    @Test
    void getOrden() {
        assertEquals(10, ob.getOrden());
    }

    @Test
    void getId_tarjeta() {
        assertEquals(1000, ob.getId_tarjeta());
    }

    @Test
    void setId() {
        ob.setId(2);
        assertEquals(2, ob.getId());
    }

    @Test
    void setId_partida() {
        ob.setId_partida(200);
        assertEquals(200, ob.getId_partida());

    }

    @Test
    void setId_tipo_baraja() {
        ob.setId_tipo_baraja(1);
        assertEquals(1, ob.getId_tipo_baraja());

    }

    @Test
    void setOrden() {
        ob.setOrden(20);
        assertEquals(20, ob.getOrden());

    }

    @Test
    void setId_tarjeta() {
        ob.setId_tarjeta(2000);
        assertEquals(2000, ob.getId_tarjeta());

    }
}