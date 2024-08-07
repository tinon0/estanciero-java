package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

@Getter
@Setter
public class Railway extends Cell {
     int value;
     String playerOwner;
     private Tablero tablero;
     private Player player;



    public Railway(boolean purchasable, String type, int number, String name, int value, String PlayerOwnwer) {
        super(purchasable, type, number, name);
        this.value =value;
        this.playerOwner = PlayerOwnwer;
    }

    public void PlayerEntered(Player pl1){
        Printer.println(colorize(pl1.getName()+ " has caido en un ferrocarril! Nombre: " + this.getName() + "Numero de celda: " + this.getNumber(), MAGENTA_TEXT(), ITALIC()));
        if(playerOwner == null){
            Printer.println(colorize("El ferrocaril no tiene jugador propietario. Valor: $" + value + ", Nombre: "+ getName(), MAGENTA_TEXT(), ITALIC()));
            if(pl1 instanceof BotEquilibrado bot){
                bot.buyRailway(this, pl1.getRailways());

            } else if(pl1 instanceof BotConservador bot){
                bot.buyRailway(this, pl1.getRailways());
            } else if(pl1 instanceof BotAgresivo bot){
                bot.buyRailway(this);
            }
            else{
                Printer.println(colorize("Tiene la oportunidad de comprar esta Ferrocaril!", MAGENTA_TEXT(), ITALIC()));
            }


        } else  {
            if(playerOwner.equals(pl1.getName())){
                Printer.println(colorize("Este Ferrocaril es del jugador actual", MAGENTA_TEXT(), ITALIC()));
            } else{
                Printer.println(colorize("Este Ferrocaril tiene de propietario al jugador " + playerOwner + ", debe pagar el alquiler", MAGENTA_TEXT(), ITALIC()));
                Pay(pl1);
                Printer.println(colorize("El jugador " +pl1.getName() + " pago el alquiler, ahora su dinero es $" + pl1.getMoney(), MAGENTA_TEXT(), ITALIC()));
            }
        }

    }

    public void Pay(Player pl1) {
        int rent =0 ;
        tablero = Tablero.getInstance();
        player = tablero.getPlayerByName(playerOwner);

        if(player.getRailways().size() ==1){
            rent = 500;
        }
        if (player.getRailways().size() == 2) {
            rent = 1000;

        }
        if (player.getRailways().size() == 3) {
            rent = 2000;
        } else if (player.getRailways().size() == 4) {
            rent = 4000;
        }

        pl1.setMoney(pl1.getMoney() - rent);
        player.setMoney(player.getMoney() + rent);
    }
}
