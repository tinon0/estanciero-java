package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Card;
import ar.edu.utn.frc.tup.lciii.model.Deck;
import ar.edu.utn.frc.tup.lciii.model.LuckyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    @Test
    void makingDeck(){
        Deck deck = new Deck("Suerte");
        assertEquals(16,deck.getCards().size());

    }
    @Test
    void addingCard(){
        Deck deck = new Deck("Destino");
        Card luckyCard = new LuckyCard(1, 1, "description");



        deck.addCard(luckyCard);

        assertFalse(deck.getCards().isEmpty());
        assertEquals(17, deck.getCards().size());
    }
    @Test
    void shufflingDeck(){
        Deck deck1 = new Deck("lucky");
        Deck deck2 = new Deck("lucky");

        Card luckyCard1 = new LuckyCard(1, 1, "description");
        Card luckyCard2 = new LuckyCard(2, 2, "description");
        Card luckyCard3 = new LuckyCard(3, 3, "description");
        Card luckyCard4 = new LuckyCard(4, 4, "description");

        deck1.addCard(luckyCard1);
        deck1.addCard(luckyCard2);
        deck1.addCard(luckyCard3);
        deck1.addCard(luckyCard4);

        deck2.addCard(luckyCard1);
        deck2.addCard(luckyCard2);
        deck2.addCard(luckyCard3);
        deck2.addCard(luckyCard4);

        deck2.shuffle();
        assertNotEquals(deck1, deck2);
    }
    @Test
    void pickingCard(){
        Deck deck = new Deck("lucky");
        Card luckyCard1 = new LuckyCard(1, 1, "description");
        Card luckyCard2 = new LuckyCard(2, 2, "description");

        deck.addCard(luckyCard1); deck.addCard(luckyCard2);

        assertEquals(luckyCard2, deck.pickCard());
    }
}
