package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import org.junit.jupiter.api.*;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FabricaTarjetaMarchePresoTest {

    private FabricaTarjetasInterface fabrica;

    @Test
    public void testCreateCard() {
        Tarjetas entity = new Tarjetas();

         fabrica = new FabricaTarjetaMarchePreso(entity);

        CardInterface card= fabrica.createCard();

        assertNotNull(card);
        assertTrue(card instanceof TarjetaMarchePreso);
    }


}
