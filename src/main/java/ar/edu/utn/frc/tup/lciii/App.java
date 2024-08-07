package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.entities.Profile;
import ar.edu.utn.frc.tup.lciii.model.HandlerPartida;
import ar.edu.utn.frc.tup.lciii.model.ProfileManager;

import java.util.Scanner;

/**
 * Hello to TPI Estanciero
 *
 */
public class App
{

    /**
     * This is the main program
     *
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HandlerPartida handlerPartida = new HandlerPartida(scanner);
        do {
            handlerPartida.moverEjecutar();
            handlerPartida.isCloseToBanckruptcy();
            handlerPartida.corroborarMuertos();
            handlerPartida.statusGamePlay();
        } while (!handlerPartida.win());
    }
}
