package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.DestinyCard;
import ar.edu.utn.frc.tup.lciii.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DestinyCardTest {
    private Player player;

    DestinyCard card = new DestinyCard(11, 2, "Habeas Corpus concedido. Con esta tarjeta sale Usted gratuitamente de la Comisar?a");
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
    void payOrLucky() {
        card.payOrLucky();
    }

    @Test
    void effect() {
        card.effect(player);
    }

    @Test
    void getId() {
        assertEquals(11, card.getId());
    }

    @Test
    void getIdEfecto() {
        assertEquals(2, card.getIdEfecto());
    }

    @Test
    void getDescription() {
        assertEquals("Habeas Corpus concedido. Con esta tarjeta sale Usted gratuitamente de la Comisar?a", card.getDescription());
    }

    @Test
    void setId() {
        card.setId(1);
        assertEquals(1, card.getId());
    }

    @Test
    void setIdEfecto() {
        card.setIdEfecto(1);
        assertEquals(1, card.getIdEfecto());
    }

    @Test
    void setDescription() {
        card.setDescription("Eso que vuela es un zombie volador");
        assertEquals("Eso que vuela es un zombie volador", card.getDescription());
    }
}