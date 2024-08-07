package ar.edu.utn.frc.tup.lciii.entities;

import ar.edu.utn.frc.tup.lciii.entities.Propiedades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropiedadesTest {
    private Propiedades propiedades;
    @BeforeEach
    void setUp() {
        propiedades = new Propiedades();
//        propiedades.setId_propiedad(1);
        propiedades.setNombre("love");
//        propiedades.setId_provincia(3);
        propiedades.setPrecio_compra(20000);
        propiedades.setValor_hipotecario(500);
//        propiedades.setId_celda(6);
    }

//    @Test
//    void getId_propiedad() {
//        assertEquals(1, propiedades.getId_propiedad());
//    }

    @Test
    void getNombre() {
        assertEquals("love", propiedades.getNombre());
    }

//    @Test
//    void getId_provincia() {
//        assertEquals(3, propiedades.getId_provincia());
//    }

    @Test
    void getPrecio() {
        assertEquals(20000, propiedades.getPrecio_compra());
    }

    @Test
    void getValor_hipotecario() {
        assertEquals(500, propiedades.getValor_hipotecario());
    }

//    @Test
//    void getId_celda() {
//        assertEquals(6, propiedades.getId_celda());
//    }
//
//    @Test
//    void setId_propiedad() {
//        propiedades.setId_propiedad(2);
//        assertEquals(2, propiedades.getId_propiedad());
//
//    }

    @Test
    void setNombre() {
        propiedades.setNombre("hate");
        assertEquals("hate", propiedades.getNombre());

    }

//    @Test
//    void setId_provincia() {
//        propiedades.setId_provincia(5);
//        assertEquals(5, propiedades.getId_provincia());
//
//    }

    @Test
    void setPrecio() {
        propiedades.setPrecio_compra(200);
        assertEquals(200, propiedades.getPrecio_compra());

    }

    @Test
    void setValor_hipotecario() {
        propiedades.setValor_hipotecario(5000);
        assertEquals(5000, propiedades.getValor_hipotecario());

    }

//    @Test
//    void setId_celda() {
//        propiedades.setId_celda(6);
//    }
}