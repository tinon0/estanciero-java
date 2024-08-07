package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Posesiones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosesionesTest {

    @Test
    void getId_posesion() {
        Posesiones pos =new Posesiones();
//        pos.setId_posesion(1);
//        assertEquals(1, pos.getId_posesion());
    }

    @Test
    void getNombre() {
        Posesiones pos =new Posesiones();
        pos.setNombre("Ferrocarril");
        assertEquals("Ferrocarril", pos.getNombre());
    }

//    @Test
//    void getPrecio() {
//        Posesiones pos = new Posesiones();
//        pos.setPrecio(1000);
//        assertEquals(1000, pos.getPrecio());
//    }

//    @Test
//    void getId_celda() {
//        Posesiones pos =new Posesiones();
//        pos.setId_celda(1);
//        assertEquals(1, pos.getId_celda());
//    }

//    @Test
//    void setId_posesion() {
//        Posesiones pos =new Posesiones();
//        pos.setId_posesion(1);
//        assertEquals(1, pos.getId_posesion());
//    }

    @Test
    void setNombre() {
        Posesiones pos =new Posesiones();
        pos.setNombre("Ferrocarril");
        assertEquals("Ferrocarril", pos.getNombre());
    }

//    @Test
//    void setPrecio() {
//        Posesiones pos =new Posesiones();
//        pos.setPrecio(1000);
//        assertEquals(1000, pos.getPrecio());
//    }

//    @Test
//    void setId_celda() {
//        Posesiones pos =new Posesiones();
//        pos.setId_celda(1);
//        assertEquals(1, pos.getId_celda());
//    }
}