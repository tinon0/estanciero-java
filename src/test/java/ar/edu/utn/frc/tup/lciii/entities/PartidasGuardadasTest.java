package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.PartidasGuardadas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartidasGuardadasTest {
    private PartidasGuardadas partidasGuardadas;

    @BeforeEach
    void setUp() {
        partidasGuardadas = new PartidasGuardadas();
        partidasGuardadas.setId_detalle(2);
        partidasGuardadas.setId_partida(1);
        partidasGuardadas.setJugador("Agus");
        partidasGuardadas.setDinero(35488);
        partidasGuardadas.setOrden_turnos(5);
        partidasGuardadas.setId_tipo_jugador(1);
    }

    @Test
    void getId_detalle() {
        assertEquals(2,partidasGuardadas.getId_detalle());
    }

    @Test
    void getId_partida() {
        assertEquals(1,partidasGuardadas.getId_partida());
    }

    @Test
    void getJugador() {
        assertEquals("Agus",partidasGuardadas.getJugador());
    }

    @Test
    void getId_tipo_jugador() {
        assertEquals(1,partidasGuardadas.getId_tipo_jugador());
    }

    @Test
    void getDinero() {
        assertEquals(35488,partidasGuardadas.getDinero());
    }

    @Test
    void getOrden_turnos() {
        assertEquals(5,partidasGuardadas.getOrden_turnos());
    }

    @Test
    void setId_detalle() {
        partidasGuardadas.setId_detalle(4);
        assertEquals(4,partidasGuardadas.getId_detalle());

    }

    @Test
    void setId_partida() {
        partidasGuardadas.setId_partida(3);
        assertEquals(3,partidasGuardadas.getId_partida());

    }

    @Test
    void setJugador() {
        partidasGuardadas.setJugador("rulo");
        assertEquals("rulo",partidasGuardadas.getJugador());

    }

    @Test
    void setId_tipo_jugador() {
        partidasGuardadas.setId_tipo_jugador(1);
        assertEquals(1,partidasGuardadas.getId_tipo_jugador());

    }

    @Test
    void setDinero() {
        partidasGuardadas.setDinero(358);
        assertEquals(358,partidasGuardadas.getDinero());

    }

    @Test
    void setOrden_turnos() {
        partidasGuardadas.setOrden_turnos(4);
        assertEquals(4,partidasGuardadas.getOrden_turnos());
    }
}