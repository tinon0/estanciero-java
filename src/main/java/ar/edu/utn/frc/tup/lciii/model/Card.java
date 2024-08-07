package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.services.CardInterface;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Card implements CardInterface {

    protected String message;
    public Card(String message) {
        this.message=message;
    }
    @Override
    public abstract void effect(Player player);
}
