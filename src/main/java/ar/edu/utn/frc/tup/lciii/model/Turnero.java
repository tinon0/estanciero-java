package ar.edu.utn.frc.tup.lciii.model;



import lombok.Getter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Turnero  implements Iterator<Player> {

    @Getter
    private int turnPointer;
    private Initiative initiative;
    private boolean isDouble = false;

    private  Integer moneyToWin;


    public Turnero(Initiative turnOrder, int moneyToWin) {
        this.turnPointer = 0;
        this.initiative = turnOrder;
        this.moneyToWin = moneyToWin;
    }

    @Override
    public boolean hasNext() {
        boolean check = true;

        if (turnPointer >= initiative.playerOrder.size()){
            check = false;
        }
        return check;
    }

    @Override
    public Player next() {
        Player turn = initiative.playerOrder.get(turnPointer);

        while (turn.isImmobile()) {
            turnPointer++;
            if (!hasNext()) {
                turnPointer = 0;
            }
            turn = initiative.playerOrder.get(turnPointer);
        }
        while (turn.isLose()) {
            turnPointer++;
            if (!hasNext()) {
                turnPointer = 0;
            }
            turn = initiative.playerOrder.get(turnPointer);
        }

        if (!isDouble) {
            turnPointer++;
        }

        if (!hasNext()){
            turnPointer=0;
        }

        return turn;
    }

    public static class Initiative implements Iterable<Player> {

        @Getter
        private List<Player> playerOrder;

        private int moneyToWin;



        public Initiative(int moneyToWin) {
            playerOrder = new LinkedList<>();
            this.moneyToWin = moneyToWin;
        }

        public void addPlayer(Player j) {
            playerOrder.add(j);
        }

        @Override
        public Iterator<Player> iterator() {
            return new Turnero(this,moneyToWin);
        }
    }
}
