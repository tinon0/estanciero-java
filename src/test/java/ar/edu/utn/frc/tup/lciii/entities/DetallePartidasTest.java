package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.DetallePartidas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetallePartidasTest {
    private DetallePartidas detalle;
    @BeforeEach
    void setUp() {
        detalle = new DetallePartidas();
        detalle.setId_partida(1);
        detalle.setId_jugador(1);
        detalle.setNombre_partida("tuki");
        detalle.setValor_ganar(20000);
        detalle.setUltimo_turno(15);
        detalle.setId_tipo_modo(2);
    }

    @Test
    void getId_partida() {
        assertEquals(1, detalle.getId_partida());
    }

    @Test
    void getNombre_partida() {
        assertEquals("tuki", detalle.getNombre_partida());
    }

    @Test
    void getId_jugador() {
        assertEquals(1, detalle.getId_jugador());
    }

    @Test
    void getId_tipo_modo() {
        assertEquals(2, detalle.getId_tipo_modo());
    }

    @Test
    void getUltimo_turno() {
        assertEquals(15, detalle.getUltimo_turno());
    }

    @Test
    void getValor_ganar() {
        assertEquals(20000, detalle.getValor_ganar());
    }

    @Test
    void setId_partida() {
        detalle.setId_partida(6);
        assertEquals(6, detalle.getId_partida());

    }

    @Test
    void setNombre_partida() {
        detalle.setNombre_partida("tako");
        assertEquals("tako", detalle.getNombre_partida());

    }

    @Test
    void setId_jugador() {
        detalle.setId_jugador(2);
        assertEquals(2, detalle.getId_jugador());

    }

    @Test
    void setId_tipo_modo() {
        detalle.setId_tipo_modo(1);
        assertEquals(1, detalle.getId_tipo_modo());
    }

    @Test
    void setUltimo_turno() {
        detalle.setUltimo_turno(25);
        assertEquals(25, detalle.getUltimo_turno());

    }

    @Test
    void setValor_ganar() {
        detalle.setValor_ganar(10000);
        assertEquals(10000, detalle.getValor_ganar());

    }
}