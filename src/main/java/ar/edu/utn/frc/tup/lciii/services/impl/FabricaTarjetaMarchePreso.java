package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class FabricaTarjetaMarchePreso extends FabricaTarjeta implements FabricaTarjetasInterface {

    private String message;
    public FabricaTarjetaMarchePreso(Tarjetas tarjetaEntity) {

        message= tarjetaEntity.getMensaje();
    }
    @Override
    public CardInterface createCard() {
        return new TarjetaMarchePreso(message);
    }
}
