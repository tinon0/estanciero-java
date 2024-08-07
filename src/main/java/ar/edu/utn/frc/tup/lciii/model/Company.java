package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import lombok.Getter;
import lombok.Setter;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

@Getter
@Setter
public class Company extends Cell {
    int value;
    String playerOwner;
    private Tablero tablero;
    private Player player;


    public Company(boolean purchasable, String type, int number, String name, int value, String playerOwner) {
        super(purchasable, type, number, name);
        this.value = value;
        this.playerOwner = playerOwner;
    }

    public void PlayerEntered(Player pl1){
        Printer.println(colorize(pl1.getName() + " has caido en una compania! llamada: " +this.getName() + " en la celda : " + this.getValue(), MAGENTA_TEXT(), ITALIC()));
        if(playerOwner == null){
            Printer.println(colorize("La compania no tiene jugador propietario. Valor: $" + value + ", Nombre: " + getName(), MAGENTA_TEXT(), ITALIC()));
            if(pl1 instanceof BotEquilibrado bot){
                bot.buyCompany(this, pl1.getCompanies());

            } else if (pl1 instanceof BotConservador bot) {
                bot.buyCompany(this, pl1.getCompanies());
            } else if (pl1 instanceof BotAgresivo bot) {
                bot.buyCompany(this, pl1.getCompanies() );
            } else{
                Printer.println(colorize("Tiene la oportunidad de comprar esta Compania!", MAGENTA_TEXT(), ITALIC()));
            }
        } else {
            if(playerOwner.equals(pl1.getName())){
                Printer.println(colorize("Esta Compania es del jugador actual", MAGENTA_TEXT(), ITALIC()));
            } else{
                Printer.println(colorize("Esta Compania de propietario al jugador " + playerOwner + ", debe pagar el alquiler", MAGENTA_TEXT(), ITALIC()));
                Pay(pl1);
                Printer.println(colorize("El jugador " +pl1.getName() + " pago el alquiler, ahora su dinero es $" + pl1.getMoney(), MAGENTA_TEXT(), ITALIC()));
            }
        }

    }

    public void Pay(Player pl1){
        int rent=Dice.getInstance().sumDice() * 100;
        tablero = Tablero.getInstance();
        player = tablero.getPlayerByName(playerOwner);
        if (tablero == null) {
            throw new IllegalStateException();
        }

        player = tablero.getPlayerByName(playerOwner);


        if (player == null) {
            throw new IllegalStateException();

        }

         if(player.getCompanies().size() == 2){
            rent= Dice.getInstance().sumDice() * 200;
        }
         player.setMoney(player.getMoney() + rent);

        pl1.setMoney(pl1.getMoney() - rent);
    }
}
