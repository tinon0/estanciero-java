package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;

import java.lang.reflect.Method;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static com.diogonunes.jcolor.AnsiFormat.*;

public class PrintStatus {
    private List<Player> jugadores;
    public PrintStatus(List<Player> jugadores){
        this.jugadores = jugadores;
    }
    public void statusGameplay(){
        for (Player player : this.jugadores){
            if(player instanceof User){
                Printer.println(colorize(
                        "Estado de: " + player.getName() + "\n" +
                                "Dinero: $" + player.getMoney() + "\n" +
                                "Posicion en Tablero: " + player.getPositionOnBoard() + "\n" +
                                "Propiedades: \n" + formatList(player.getProperties()) + "\n" +
                                "Railes: \n" + formatList(player.getRailways()) + "\n" +
                                "Compañias: \n" + formatList(player.getCompanies()) + "\n",
                        BLACK_TEXT(),
                        GREEN_BACK()
                ));
            }
            if (player instanceof BotConservador){
                Printer.println(colorize(
                        "Estado de: " + player.getName() + "\n" +
                                "Dinero: $" + player.getMoney() + "\n" +
                                "Posicion en Tablero: " + player.getPositionOnBoard() + "\n" +
                                "Propiedades: \n" + formatList(player.getProperties()) + "\n" +
                                "Railes: \n" + formatList(player.getRailways()) + "\n" +
                                "Compañias: \n" + formatList(player.getCompanies()) + "\n",
                        BLACK_TEXT(),
                        BLUE_BACK()
                ));
            }
            if (player instanceof BotAgresivo){
                Printer.println(colorize(
                        "Estado de: " + player.getName() + "\n" +
                                "Dinero: $" + player.getMoney() + "\n" +
                                "Posicion en Tablero: " + player.getPositionOnBoard() + "\n" +
                                "Propiedades: \n" + formatList(player.getProperties()) + "\n" +
                                "Railes: \n" + formatList(player.getRailways()) + "\n" +
                                "Compañias: \n" + formatList(player.getCompanies()) + "\n",
                        BLACK_TEXT(),
                        RED_BACK()
                ));
            }
            if (player instanceof BotEquilibrado){
                Printer.println(colorize(
                        "Estado de: " + player.getName() + "\n" +
                                "Dinero: $" + player.getMoney() + "\n" +
                                "Posicion en Tablero: " + player.getPositionOnBoard() + "\n" +
                                "Propiedades: \n" + formatList(player.getProperties()) + "\n" +
                                "Railes: \n" + formatList(player.getRailways()) + "\n" +
                                "Compañias: \n" + formatList(player.getCompanies()) + "\n",
                        BLACK_TEXT(),
                        YELLOW_BACK()
                ));
            }
        }
    }
    private <T> String formatList(List<T> lista){
        StringBuilder sb = new StringBuilder();
        for (T item : lista) {
            try {
                Method getNameMethod = item.getClass().getMethod("getName");
                String name = (String) getNameMethod.invoke(item);
                sb.append(name);

                try {
                    Method getProvinceMethod = item.getClass().getMethod("getProvince");
                    String province = (String) getProvinceMethod.invoke(item);
                    sb.append(", ").append(province);
                } catch (NoSuchMethodException e) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
