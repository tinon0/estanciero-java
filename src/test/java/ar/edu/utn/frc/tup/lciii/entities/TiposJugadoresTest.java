package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposJugadores;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposJugadoresTest {

    @Test
    void getId_tipo_jugador() {
        TiposJugadores tipo = new TiposJugadores();
        tipo.setId_tipo_jugador(1);
        assertEquals(1, tipo.getId_tipo_jugador());
    }

    @Test
    void getTipo() {
        TiposJugadores tipo = new TiposJugadores();
        tipo.setTipo("Bot");
        assertEquals("Bot", tipo.getTipo());
    }

}