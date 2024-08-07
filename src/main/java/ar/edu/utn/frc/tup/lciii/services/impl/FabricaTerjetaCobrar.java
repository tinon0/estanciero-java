package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;

public class FabricaTerjetaCobrar extends FabricaTarjeta implements FabricaTarjetasInterface {

    int money;
    String message;

    public FabricaTerjetaCobrar(Tarjetas tarjetaEntity) {
        money = tarjetaEntity.getEffecto_modificador();
        message =tarjetaEntity.getMensaje();
    }

    @Override
    public CardInterface createCard() {
        return new TarjetaCobrar(money,message);
    }
}
