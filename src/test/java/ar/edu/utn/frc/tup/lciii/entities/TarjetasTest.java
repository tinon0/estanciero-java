package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarjetasTest {

//    @Test
//    void getId_tarjeta() {
//        Tarjetas tarjetas = new Tarjetas();
//        tarjetas.setId_tarjeta(1);
//        assertEquals(1, tarjetas.getId_tarjeta());
//    }

    @Test
    void getMensaje() {
        Tarjetas tarjetas = new Tarjetas();
        tarjetas.setMensaje("Manche Preso");
        assertEquals("Manche Preso", tarjetas.getMensaje());
    }

    @Test
    void getId_tipo_efecto() {
        Tarjetas tarjetas = new Tarjetas();
        tarjetas.setId_tipo_efecto(2);
        assertEquals(2, tarjetas.getId_tipo_efecto());
    }

//    @Test
//    void getId_tipo_tarjeta() {
//        Tarjetas tarjetas = new Tarjetas();
//        tarjetas.setId_tipo_tarjeta(1);
//        assertEquals(1, tarjetas.getId_tipo_tarjeta());
//    }

    @Test
    void testGetModificadorEffecto(){
        Tarjetas tarjeta = new Tarjetas();
        tarjeta.setEffecto_modificador(1);
        assertEquals(1, tarjeta.getEffecto_modificador());
    }
    @Test
    void testSetModificadorEffecto() {
        Tarjetas tarjeta = new Tarjetas();
        tarjeta.setEffecto_modificador(1);
        assertEquals(1, tarjeta.getEffecto_modificador());
    }

}