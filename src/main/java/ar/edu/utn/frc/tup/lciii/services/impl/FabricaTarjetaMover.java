package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class FabricaTarjetaMover extends FabricaTarjeta implements FabricaTarjetasInterface {

    private int destiny;
    private String message;

    public FabricaTarjetaMover(Tarjetas tarjetaEntity) {
        destiny=tarjetaEntity.getEffecto_modificador();
        message= tarjetaEntity.getMensaje();
    }

    @Override
    public CardInterface createCard() {
        return new TarjetaMovimiento(destiny,message);
    }
}
