package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class FabricaTarjetaSalirComisaria extends FabricaTarjeta implements FabricaTarjetasInterface {

    private String message;

    public FabricaTarjetaSalirComisaria(Tarjetas tarjetas) {
        message=tarjetas.getMensaje();
    }

    @Override
    public CardInterface createCard() {
        return new TarjetaSalirComisaria(message);
    }
}
