package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.*;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TargetCellTest {


    @Test
    void testPlayerEntered() {
        Deck deck = new Deck("destiny");
        Card destiny1 = new DestinyCard();
        Card destiny2 = new DestinyCard();

        deck.addCard(destiny1);
        deck.addCard(destiny2);

        TargetCell tc = new TargetCell(false, "destiny", 7, "celda suerte");

        User u = new User("lolo");
        tc.PlayerEntered(u);
        Card pickedCard = deck.pickCard();

        assertEquals(destiny2, pickedCard);
    }

    @Test
    void testPlayerEntered_EmptyDeck() {
        Deck deck = new Deck("destiny");
        TargetCell tc = new TargetCell(false, "destiny", 6, "celda destino");

        User u = new User("lolo2");


    }

    @Test
    void testPlayerEntered_DrawCard() {
        Deck d = new Deck("destiny");
        TargetCell celda = new TargetCell(false, "destiny", 5, "celda destino");

        Card destinyCard1 = new DestinyCard();
        Card destinyCard2 = new DestinyCard();

        d.addCard(destinyCard1);
        d.addCard(destinyCard2);
        User u = new User("lolo");

        celda.PlayerEntered(u);
        d.shuffle();

        Card drawnCard = d.pickCard();
        assertNotNull(drawnCard);
        assertTrue(drawnCard.equals(destinyCard1) || drawnCard.equals(destinyCard2));
    }
}

