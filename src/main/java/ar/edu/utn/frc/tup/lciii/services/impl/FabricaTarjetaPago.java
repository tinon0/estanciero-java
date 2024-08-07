package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.FabricaTarjetasInterface;
import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import lombok.Data;


@Data
public class FabricaTarjetaPago extends FabricaTarjeta implements FabricaTarjetasInterface {

     private int money;
     private String message;

    public FabricaTarjetaPago(Tarjetas tarjetaEntity) {
        money = tarjetaEntity.getEffecto_modificador();
        message = tarjetaEntity.getMensaje();
    }


    @Override
    public CardInterface createCard() {
        return new TarjetaPago(money,message);
    }
}
