package ar.edu.utn.frc.tup.lciii.services.impl;


import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import lombok.Getter;


public abstract class FabricaTarjeta {
   public CardInterface deliverCard() {
       CardInterface card = createCard();

       return card;
   }
    public abstract CardInterface createCard();
}
