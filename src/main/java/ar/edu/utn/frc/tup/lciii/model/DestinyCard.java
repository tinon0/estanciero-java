package ar.edu.utn.frc.tup.lciii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinyCard extends Card{
    private int id;
    private int idEfecto;
    private String description;
    public void giveMoney() {

    }
    public void takeMoney() {

    }
    public void move() {

    }
    public void jail() {

    }
    public void outOfJail() {

    }
    public void payOrLucky(){}

    @Override
    public void effect(Player player) {
        switch (idEfecto){
            case 1:
                giveMoney();
            case 2:
                move();
            case 3:
                takeMoney();
            case 4:
                jail();
            case 5:
                outOfJail();
            case 6:
                payOrLucky();
        }
    }
}
