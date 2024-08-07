package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import lombok.Getter;
import lombok.Setter;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

@Getter
@Setter
public class Property extends Cell {
    private int chacras;
    private int residence;
    private int value;
    private int mortgageValue;
    private String province;
    private String playerOwner;
    private boolean isBusy;
    private Tablero tablero;
    private Player player;

    private int precio_mejora;
    private int alquiler_base;
    private int alquiler_1chacra;
    private int alquiler_2chacra;
    private int alquiler_3chacra;
    private int alquiler_4chacra;
    private int alquiler_1estancia;

    public Property(boolean purchasable, String type, int number, String name, int chacras, int residence, int value, int mortgageValue, String province, String playerOwner, boolean isBusy, int precio_mejora, int alquiler_base, int alquiler_1chacra, int alquiler_2chacra, int alquiler_3chacra, int alquiler_4chacra, int alquiler_1estancia) {
        super(purchasable, type, number, name);
        this.chacras = chacras;
        this.residence = residence;
        this.value = value;
        this.mortgageValue = mortgageValue;
        this.province = province;
        this.playerOwner = playerOwner;
        this.isBusy = isBusy;
        this.precio_mejora = precio_mejora;
        this.alquiler_base = alquiler_base;
        this.alquiler_1chacra = alquiler_1chacra;
        this.alquiler_2chacra = alquiler_2chacra;
        this.alquiler_3chacra = alquiler_3chacra;
        this.alquiler_4chacra = alquiler_4chacra;
        this.alquiler_1estancia = alquiler_1estancia;
    }

    private int calculateRent() {
        if (residence > 0) {
            return alquiler_1estancia;
        }
        if (chacras == 1) {
            return alquiler_1chacra;
        }
        if (chacras == 2) {
            return alquiler_2chacra;
        }
        if (chacras == 3) {
            return alquiler_3chacra;
        }
        if (chacras == 4) {
            return alquiler_4chacra;
        }
        return alquiler_base;
    }

    public void PlayerEntered(Player pl1) {
        if (playerOwner == null) {
            Printer.println(colorize(pl1.getName()+" a Caido en la propiedad de "+province+": "+getName()+" su precio de compra es: " +value+" y el jugador tiene: "+pl1.getMoney()+"$",MAGENTA_TEXT(),ITALIC()));
            Printer.println(colorize("La propiedad no tiene jugador propietario. Valor: $"+ value + ", Nombre: " + getName() + ", Provincia: " + province, MAGENTA_TEXT(), ITALIC()));
            if(pl1 instanceof BotEquilibrado bot){
                bot.buyProperty(bot.getProperties(), this);

            } else if (pl1 instanceof BotConservador bot) {
                bot.buyProperty(pl1.getProperties(), this);

            } else if (pl1 instanceof BotAgresivo bot) {
                bot.buyProperty(pl1.getProperties(), this);

            } else{
                Printer.println(colorize("Tiene la oportunidad de comprar esta Propiedad!", MAGENTA_TEXT(), ITALIC()));
            }


        } else {
            int rent = calculateRent();

            if(playerOwner.equals(pl1.getName())){
                Printer.println(colorize("Esta Propiedad es del jugador actual", MAGENTA_TEXT(), ITALIC()));
            } else{
                Printer.println(colorize("Esta Propiedad tiene de propietario al jugador " + playerOwner + ", debe pagar el alquiler de "+calculateRent(), MAGENTA_TEXT(), ITALIC()));
                Pay(pl1, rent);
                Printer.println(colorize("El jugador " +pl1.getName() + " pago el alquiler, ahora su dinero es $" + pl1.getMoney(), MAGENTA_TEXT(), ITALIC()));
            }
        }

    }
     public int calculateValue(int valueChacra,int valueRecidence)
     {
         int valueFinal = value +(valueChacra/2) + (valueRecidence/2);
         return valueFinal;
     }
     public void Pay(Player pl1, int rent){
        tablero = Tablero.getInstance();
        player = tablero.getPlayerByName(playerOwner);
        player.setMoney(pl1.getMoney()+ rent);
         pl1.setMoney(pl1.getMoney() - rent);
     }
}
