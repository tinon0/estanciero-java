package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;

import static org.junit.jupiter.api.Assertions.*;

public class FabricaTarjetaSalirComisariaTest {
    private FabricaTarjetasInterface fabrica;
    private Tarjetas entity = new Tarjetas();

    @Test
    public void testCreateCard() {

        fabrica = new FabricaTarjetaSalirComisaria(entity);

        CardInterface card= fabrica.createCard();

        assertNotNull(card);
        assertInstanceOf(TarjetaSalirComisaria.class, card);
    }
}
