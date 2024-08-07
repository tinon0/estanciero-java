package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.*;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;


public class LuckCellTest {

    @Test
    void testPlayerEntered(){
        Deck d = new Deck("lucky");


        Card LuckyCard1 = new LuckyCard(1, 1, "description");
        Card LuckyCard2 = new LuckyCard(2, 2, "description");

        d.addCard(LuckyCard1); d.addCard(LuckyCard2);
        LuckCell lc = new LuckCell(false, "lucky", 7, "celda suerte"  );
        User u = new User("lolo");
        lc.PlayerEntered(u);
        Card pickedCard = d.pickCard();

        assertEquals(LuckyCard2,  pickedCard);



    }

    @Test
    void testPlayerEntered_DrawCard(){

        Deck d = new Deck("lucky");

        Card LuckyCard1 = new LuckyCard(1, 1, "description");
        Card LuckyCard2 = new LuckyCard(2, 2, "description");
        LuckCell lc = new LuckCell(false, "lucky", 7, "celda suerte");
        d.addCard(LuckyCard1); d.addCard(LuckyCard2);
        d.shuffle();
        User u = new User("lolo");
        lc.PlayerEntered(u);
        Card drawnCard =d.pickCard();
        assertNotNull(drawnCard);
        assertTrue(drawnCard.equals(LuckyCard1) || drawnCard.equals(LuckyCard2));
    }

}
