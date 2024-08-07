package ar.edu.utn.frc.tup.lciii.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Dice {
    private static Dice instance;
    private int die1;
    private int die2;
    private int doubleCounter;
    private static final int MAX_NUMBER =6;
    private static final Random random = new Random();
    private Dice() {}
    public static  synchronized Dice getInstance(){
        if(instance == null){
            instance = new Dice();
        }
        return instance;
    }
    public void rollDice() {

        die1 = random.nextInt(MAX_NUMBER) + 1;
        die2 = random.nextInt(MAX_NUMBER) + 1;
    }
    public int sumDice(){
        return die2 + die1;
    }
    public  boolean isDouble(){
        if(die2 == die1){
            doubleCounter ++;
            return true;
        }
        doubleCounter = 0;
        return false;
    }
    public boolean isTriple(){
        return doubleCounter ==3;
    }
}
