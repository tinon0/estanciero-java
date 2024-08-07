package ar.edu.utn.frc.tup.lciii.services.impl;


import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;

import ar.edu.utn.frc.tup.lciii.services.impl.FabricaTarjetaPago;
import ar.edu.utn.frc.tup.lciii.services.impl.TarjetaPago;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;


import static org.junit.jupiter.api.Assertions.*;

public class FabricaTarjetaPagoTest {
    private FabricaTarjeta fabrica;

    private Tarjetas entity = new Tarjetas();

    @Test
    public void testDeliverCard() {

        entity.setEffecto_modificador(1);

        fabrica = new FabricaTarjetaPago(entity);

        CardInterface card = fabrica.deliverCard();

        assertInstanceOf(TarjetaPago.class,card);


    }

    @Test
    public void testCreateCard() {
        entity.setEffecto_modificador(1);

        fabrica = new FabricaTarjetaPago(entity);

        CardInterface card= fabrica.createCard();

        assertNotNull(card);
        assertInstanceOf(TarjetaPago.class, card);
    }
}
