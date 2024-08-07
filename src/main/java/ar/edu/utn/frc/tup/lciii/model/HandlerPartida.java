package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.services.Cell;
import ar.edu.utn.frc.tup.lciii.services.PlayerInterface;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import ar.edu.utn.frc.tup.lciii.services.impl.PlayerServiceImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;
@Getter
@Setter
public class HandlerPartida {
    private Deck deckLucky;
    private Deck deckDestiny;
    private Bank bank;
    private Tablero tablero;
    private Turnero turnero;
    private Turnero.Initiative iniciativa;
    private List<Player> jugadores;
    private transient Scanner scan;
    private User usuario;
    private List<Property> propiedades;
    private PlayerInterface playerService;
    private int moneyToWin;
    private String name;
    private PrintStatus printStatus;
    private boolean retired;

    public HandlerPartida(Scanner scanner) {
        this.scan = scanner;
        this.name = setNameMatch();
        this.deckDestiny = new Deck("Destino");
        this.deckLucky = new Deck("Suerte");
        this.tablero = Tablero.getInstance();
        this.propiedades = new ArrayList<>();
        this.bank = new Bank();

        this.moneyToWin = settingMoneyVictory();
        this.iniciativa = new Turnero.Initiative(moneyToWin);

        this.turnero = new Turnero(this.iniciativa, moneyToWin);
        this.jugadores = new ArrayList<>();
        this.usuario = crearUsuario();
        this.jugadores.add(this.usuario);
        dificultadSpawnBot();
        this.printStatus = new PrintStatus(this.jugadores);
        this.playerService = new PlayerServiceImpl();
        this.retired=false;
    }
    private void dificultadSpawnBot() {
        Scanner scanner = this.scan;
        Printer.println("Elegir la dificultad de la partida: \n" +
                "1. FACIL \n" +
                "2. MEDIO \n" +
                "3. DIFICIL \n");
        int resultado = scanner.nextInt();

        switch (resultado) {
            case 1 -> {
                this.jugadores.add(new BotEquilibrado("Chupete Suazo"));
                this.jugadores.add(new BotConservador("Chino Maidana"));
                List<Player> jugadores = this.tablero.ordering(this.getJugadores());
                jugadores.forEach(
                        jugador -> {
                            this.iniciativa.addPlayer(jugador);
                        }
                );
            }
            case 2 -> {
                this.jugadores.add(new BotEquilibrado("Luciano Pereyra"));
                this.jugadores.add(new BotConservador("Abel Pintos"));
                this.jugadores.add(new BotAgresivo("Leonel Messi"));
                List<Player> jugadores = this.tablero.ordering(this.getJugadores());
                jugadores.forEach(
                        jugador -> {
                            this.iniciativa.addPlayer(jugador);
                        }
                );
            }
            case 3 -> {
                this.jugadores.add(new BotEquilibrado("La Brujita Veron"));
                this.jugadores.add(new BotConservador("Dj Mario"));
                this.jugadores.add(new BotConservador("Vegetta 777"));
                this.jugadores.add(new BotAgresivo("Manu Ginobili"));
                List<Player> jugadores = this.tablero.ordering(this.getJugadores());
                jugadores.forEach(
                        jugador -> {
                            this.iniciativa.addPlayer(jugador);
                        }
                );
            }

        }
    }

    public void menuDecision() {
        Scanner scanner = this.scan;
        Printer.println("Tu turno " + this.usuario.getName() + "\n" +
                "Elegir:\n" +
                "1. Tirar dados y seguir \n" +
                "2. Comprar \n" +
                "3. Vender \n" +
                "4. Mejorar \n" +
                "5. Salir de la partida"
        );
        int resultado = scan.nextInt();
        switch (resultado) {
            case 1 -> moverEjecutar();
            case 2 -> comprarPlayer();
            case 3 -> vender();
            case 4 -> mejorarPropiedad();
            case 5 -> retired=true;
        }
    }

    private User crearUsuario() {
        Scanner scanner = this.scan;
        Printer.println("Ingresa tu nombre de usuario: ");
        String nombre = scanner.nextLine();
        User user = new User(nombre);
        return user;
    }

    private void comprarPlayer() {
        Cell cell = this.tablero.obtenerCasilla(usuario.getPositionOnBoard());
        if (cell instanceof Property property) {
            comprarProperty(property);
        } else if (cell instanceof Railway railway) {
            comprarRailway(railway);
        } else if (cell instanceof Company company) {
            comprarCompany(company);
        } else {
            Printer.println("No estas en una casilla que se pueda comprar.");
        }
    }

    private void comprarProperty(Property property) {
        if (property.getPlayerOwner() == null) {
            if (usuario.getMoney() >= property.getValue()) {
                usuario.setMoney(usuario.getMoney() - property.getValue());
                playerService.buyProperty(usuario.getProperties(), property);
                property.setPlayerOwner(usuario.getName());
                Printer.println(colorize("Has comprado " + property.getName(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));
            } else {
                Printer.println(colorize("No tienes suficiente dinero para comprar esta propiedad.", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
            }
        } else {
            Printer.println(colorize("Esta propiedad ya tiene propietario.", BLACK_TEXT(), WHITE_BACK()));
        }
    }

    private void comprarRailway(Railway railway) {
        if (railway.getPlayerOwner() == null) {
            if (usuario.getMoney() >= railway.getValue()) {
                usuario.setMoney(usuario.getMoney() - railway.getValue());
                playerService.buyRailway(railway, usuario.getRailways());
                railway.setPlayerOwner(usuario.getName());
                Printer.println(colorize("Has comprado " + railway.getName(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));

            } else {
                Printer.println(colorize("No tienes suficiente dinero para comprar este ferrocaril!", BLACK_TEXT(), WHITE_BACK(), ITALIC()));

            }
        } else {
            Printer.println(colorize("Este ferrocaril ya tiene propietario", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }
    }

    private void comprarCompany(Company company) {
        if (company.getPlayerOwner() == null) {
            if (usuario.getMoney() >= company.getValue()) {
                usuario.setMoney(usuario.getMoney() - company.getValue());
                playerService.buyCompany(company, usuario.getCompanies());
                company.setPlayerOwner(usuario.getName());
                Printer.println(colorize("Has comprado " + company.getName(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));

            } else {
                Printer.println(colorize("No tienes suficiente dinero para comprar esta compania!", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
            }
        } else {
            Printer.println(colorize("Esta compania ya tiene propietario", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }
    }

    private void venderPlayer() {
        List<Property> propiedadesUsuario = usuario.getProperties();
        Printer.println(colorize("Propiedades de " + usuario.getName() + ":", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        for (int i = 0; i < propiedadesUsuario.size(); i++) {
            Property propiedad = propiedadesUsuario.get(i);
            Printer.println(colorize((i + 1) + ". " + propiedad.getName() + " $" + propiedad.getValue(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }
        Scanner scanner = this.scan;
        Printer.println(colorize("Seleccione el numero de la propiedad que desea vender: ", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        int opcion = scanner.nextInt();
        if (opcion >= 1 && opcion <= propiedadesUsuario.size()) {
            Property propertyaVender = propiedadesUsuario.get(opcion - 1);
            playerService.sellProperty(propiedadesUsuario, propertyaVender, usuario);
        } else {
            Printer.println(colorize("Opcion invalida.", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }

    }

    private int settingMoneyVictory() {
        Scanner scanner = this.scan;
        Printer.println("Por favor, ingresa el dinero necesario para que un jugador gane la partida");
        boolean correcto = false;
        int value = 100000;
        while (!correcto) {
            long money = scanner.nextLong();

            scanner.nextLine();
            if (money>=35000&&money<2000000000) {

                value = Math.toIntExact(money);
                correcto = true;
                return value;
            }
            Printer.println("el valor ingresado debe ser mayor que 35.000 y menor que 2.000.000.000");
        }
        return value;
    }

    public boolean win() {
        if (retired){
            Printer.println(colorize(usuario.getName()+" se ha retirado, perdiendo el juego", BLACK_TEXT(), RED_BACK()));
            return true;
        }
        if (this.jugadores.size() == 1){
            Printer.println(colorize("Qudaron 1 y gano: " + this.jugadores.get(0).getName(), BLACK_TEXT(), GREEN_BACK()));
            return true;
        }
        for (Player player : this.jugadores){
            if(player.getMoney() >= moneyToWin){
                Printer.println(colorize(this.jugadores.get(0).getName() + " supero el dinero para ganar!", BLACK_TEXT(), GREEN_BACK()));
                return true;
            }
        }
        return false;
    }

    public Player nextPlayer() {
        return this.turnero.next();
    }
    public void moverEjecutar() {
        Player actualTurn = this.nextPlayer();
        if (!actualTurn.isBot()) {
            menuDecision();
            this.tablero.moverJugador(actualTurn);
            if (this.tablero.isSuerte()) {
                Card card= deckLucky.pickCard();
                card.effect(actualTurn);
                this.tablero.setSuerte(false);
            }
            if (this.tablero.isDestino()) {
                Card card= deckDestiny.pickCard();
                card.effect(actualTurn);
                this.tablero.setDestino(false);
            }
        } else {
            this.tablero.moverJugador(actualTurn);
            if (this.tablero.isSuerte()) {
               Card card= deckLucky.pickCard();
               card.effect(actualTurn);
               this.tablero.setSuerte(false);
            }
            if (this.tablero.isDestino()) {
                Card card= deckDestiny.pickCard();
                card.effect(actualTurn);
                this.tablero.setDestino(false);
            }
        }
    }

    public void statusGamePlay() {
        this.printStatus.statusGameplay();
    }

    public String setNameMatch() {
        Scanner scanner = this.scan;
        Printer.println("Ingresa un nombre para la partida:");
        String name =scanner.nextLine();
        return name;
    }

    public void venderFerrocariles() {
        List<Railway> ferrocarrilesUsuario = usuario.getRailways();
        Printer.println(colorize("Ferrocarriles de " + usuario.getName() + ":", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        for (int i = 0; i < ferrocarrilesUsuario.size(); i++) {
            Railway railway = ferrocarrilesUsuario.get(i);
            Printer.println(colorize((i + 1) + "." + railway.getName() + " $" + railway.getValue(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }
        Scanner scanner = this.scan;
        Printer.println(colorize("Seleccione el numero del ferrocaril que desea vender: ", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        int opcion = scanner.nextInt();
        if (opcion >= 1 && opcion <= ferrocarrilesUsuario.size()) {
            Railway railway = ferrocarrilesUsuario.get(opcion - 1);
            playerService.sellRailway(ferrocarrilesUsuario, railway, usuario);
        }
    }
    public void venderCompania() {
        List<Company> companiasUsuario = usuario.getCompanies();
        Printer.println(colorize("Companias de " + usuario.getName() + ":", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        for (int i = 0; i < companiasUsuario.size(); i++) {
            Company company = companiasUsuario.get(i);
            Printer.println(colorize((i + 1) + "." + company.getName() + " $" + company.getValue(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        }
        Scanner scanner = this.scan;
        Printer.println(colorize("Seleccione el numero de la compania que desea vender: ", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
        int opcion = scanner.nextInt();
        if (opcion >= 1 && opcion <= companiasUsuario.size()) {
            Company company = companiasUsuario.get(opcion - 1);
            playerService.sellCompany(companiasUsuario, company , usuario);
        }
    }

    public void isCloseToBanckruptcy() {
        if (usuario.getMoney() <= usuario.getBancarrota()) {
            Printer.println(colorize("Oh no! se encuentra cerca de la bancarrota, necesita vender \n" +
                                            "una de sus Propiedades, Ferrocariles o Companias para poder evitar la bancarrota", BLACK_TEXT(), WHITE_BACK(), ITALIC()));
            vender();
        }

    }
    public void mejorarPropiedad(){
        this.usuario.addImprovements(this.tablero.obtenerCasilla(this.usuario.getPositionOnBoard()), this.bank);
    }
    public void vender(){
        Printer.println(colorize("Qué deseas vender " + this.usuario.getName() + "? \n" +
                "Elegir: \n" +
                "1. Propiedades \n" +
                "2. Ferrocarriles \n" +
                "3. Companias \n", BLACK_TEXT(), WHITE_BACK(), ITALIC()));

        int resultado = scan.nextInt();
        switch (resultado) {
            case 1 -> venderPlayer();
            case 2 -> venderFerrocariles();
            case 3 -> venderCompania();
        }
    }
    public void corroborarMuertos(){
        Player playerToLose = null;
        for (Player player : this.jugadores){
            if (player.getMoney() <= player.getBancarrota()){
                playerToLose = player;
                playerToLose.setLose(true);
            }
        }
        if (playerToLose != null){
            Printer.println(colorize(playerToLose.getName() + " perdio!", BLACK_TEXT(), BLUE_BACK()));
        }
        this.jugadores.remove(playerToLose);
    }
}