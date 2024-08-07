package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.LuckyCard;
import ar.edu.utn.frc.tup.lciii.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyCardTest {
    private Player player;

    LuckyCard card = new LuckyCard(5,1, "Gastos de Farmacia. Pague 1000");
    @Test
    void giveMoney() {
        card.giveMoney();
    }

    @Test
    void takeMoney() {
        card.takeMoney();
    }

    @Test
    void move() {
        card.move();
    }

    @Test
    void jail() {
        card.jail();
    }

    @Test
    void outOfJail() {
        card.outOfJail();
    }

    @Test
    void effect() {
        card.effect(player);
    }

    @Test
    void getId() {
        assertEquals(5, card.getId());
    }

    @Test
    void getIdEfecto() {
        assertEquals(1, card.getIdEfecto());
    }

    @Test
    void getDescription() {
        assertEquals("Gastos de Farmacia. Pague 1000", card.getDescription());
    }

    @Test
    void setId() {
        card.setId(2);
        assertEquals(2, card.getId());
    }

    @Test
    void setIdEfecto() {
        card.setIdEfecto(1);
        assertEquals(1, card.getIdEfecto());
    }

    @Test
    void setDescription() {
        card.setDescription("Pagar mucho dinero");
        assertEquals("Pagar mucho dinero", card.getDescription());
    }
}