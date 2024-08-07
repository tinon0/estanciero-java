package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.TiposTarjetas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TiposTarjetasTest {

    @Test
    void getId_tipo_tarjeta() {
        TiposTarjetas tipo = new TiposTarjetas();
        tipo.setId_tipo_tarjeta(1);
        assertEquals(1, tipo.getId_tipo_tarjeta());
    }

    @Test
    void getDescripcion() {
        TiposTarjetas tipo = new TiposTarjetas();
        tipo.setDescripcion("Tarjeta Suerte Pagar $1000");
        assertEquals("Tarjeta Suerte Pagar $1000", tipo.getDescripcion());
    }
}