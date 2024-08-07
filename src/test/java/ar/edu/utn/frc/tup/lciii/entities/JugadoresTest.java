package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Jugadores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadoresTest {
    private Jugadores j1;

    @BeforeEach
    void setUp() {
        j1 = new Jugadores();
        j1.setId_jugador(1);
        j1.setCant_victorias(10);
        j1.setCant_derrotas(10);
        j1.setJugador_nombre("marco");
    }

    @Test
    void getId_jugador() {
        assertEquals(1, j1.getId_jugador());
    }

    @Test
    void getJugador_nombre() {
        assertEquals("marco", j1.getJugador_nombre());
    }

    @Test
    void getCant_victorias() {
        assertEquals(10, j1.getCant_victorias());
    }

    @Test
    void getCant_derrotas() {
        assertEquals(10, j1.getCant_derrotas());
    }

    @Test
    void setId_jugador() {
        j1.setId_jugador(2);
        assertEquals(2, j1.getId_jugador());
    }

    @Test
    void setJugador_nombre() {
        j1.setJugador_nombre("polo");
        assertEquals("polo", j1.getJugador_nombre());

    }

    @Test
    void setCant_victorias() {
        j1.setCant_victorias(100);
        assertEquals(100, j1.getCant_victorias());

    }

    @Test
    void setCant_derrotas() {
        j1.setCant_derrotas(0);
        assertEquals(0, j1.getCant_derrotas());

    }
}