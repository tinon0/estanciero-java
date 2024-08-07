package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class FabricaTarjetaPagoSuerte extends FabricaTarjeta implements FabricaTarjetasInterface {
    private int pago;
    private String message;

    public FabricaTarjetaPagoSuerte(Tarjetas tarjetaEntity) {
        pago = tarjetaEntity.getEffecto_modificador();
        message=tarjetaEntity.getMensaje();
    }

    @Override
    public CardInterface createCard() {
        return new TarjetaPagoSuerte(pago,message);
    }
}
