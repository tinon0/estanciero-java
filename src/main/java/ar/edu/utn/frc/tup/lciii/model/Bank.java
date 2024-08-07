package ar.edu.utn.frc.tup.lciii.model;


import ar.edu.utn.frc.tup.lciii.Printer;

import lombok.Getter;


import java.util.HashMap;
import java.util.Map;
@Getter
public class Bank {
    private Map<String, Integer> cantidadMejoras;

    public Bank() {
        this.cantidadMejoras = new HashMap<>();
        cantidadMejoras.put("Chacras", 32);
        cantidadMejoras.put("Estancias", 12);
    }

    public static void giveMoney(Player player, int money) {
        player.setMoney(player.getMoney() + money);
    }

    public static void takeMoney(Player player, int money) {
        int currentMoney = player.getMoney();
        if (currentMoney >= money) {
            player.setMoney(currentMoney - money);
        } else {
            Printer.println("No tienes suficiente dinero. Necesitas vender propiedades o tomar otra acción.");
        }
    }
}
