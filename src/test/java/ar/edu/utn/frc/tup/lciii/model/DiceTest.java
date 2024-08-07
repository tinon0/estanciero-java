package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Dice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    Dice dice = Dice.getInstance();

    @Test
    @DisplayName("Getting unique Dice instance")
    void getInstance() {
        Dice objDice = Dice.getInstance();
        assertNotNull(dice);
    }

    @Test
    @DisplayName("Random numbers between 1 and 6 included.")
    void rollDice() {
        dice.rollDice();
        assertTrue(dice.getDie1() >= 1 && dice.getDie1() <= 6);
        assertTrue(dice.getDie2() >= 1 && dice.getDie2() <= 6);
    }

    @Test
    @DisplayName("Sum of the dice < 12")
    void sumDice() {
        dice.rollDice();
        dice.sumDice();
        assertTrue(dice.sumDice() <= 12);
    }



    @Test
    @DisplayName("Double?")
    void isDouble() {
        dice.setDie1(3);
        dice.setDie2(3);
        assertTrue(dice.isDouble());
    }

    @Test
    @DisplayName("Triple?")
    void isTriple_true() {
        dice.setDoubleCounter(3);
        assertTrue(dice.isTriple());
    }

    @Test
    @DisplayName("Not Triple?")
    void isTriple_false() {
        dice.setDoubleCounter(1);
        assertFalse(dice.isTriple());
    }
}