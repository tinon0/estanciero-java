package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.entities.Celdas;
import ar.edu.utn.frc.tup.lciii.entities.GameData;
import ar.edu.utn.frc.tup.lciii.entities.Posesiones;
import ar.edu.utn.frc.tup.lciii.entities.Propiedades;
import ar.edu.utn.frc.tup.lciii.services.impl.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;

@Getter
@Setter
public class Tablero {


    private Map<Integer, Cell> board;

    private List<Player> playerOrder;
    private int dificulty;


    private boolean suerte;
    private boolean destino;

    private static Tablero instance;


    private Tablero() {
        board = new HashMap<Integer, Cell>();
        suerte = false;
        destino = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GameData gameData = null;



        try (FileReader reader = new FileReader("GameData.json")) {
            gameData = gson.fromJson(reader, GameData.class);

        } catch (IOException e )
        {
            e.printStackTrace();
        }

       if(gameData !=null) {
           llenarTablero(gameData);


       }
    }
    public void llenarTablero(GameData gameData){
        List<Celdas> celdasData = gameData.getCeldas();
        PropertyManager propertyManager = PropertyManager.getInstance();
        for (Celdas celdas : celdasData){
            int idCelda = celdas.getId_celda();
            int tipoCelda = celdas.getTipo_celda();
            Cell cell = null;
            switch (tipoCelda){
                case 1:
                    for(Propiedades propiedades : gameData.getPropiedades()) {
                        if (propiedades.getCelda()==idCelda) {
                            FabricaCell fabricaCell = new FabricaCellProperty();
                            cell = fabricaCell.createCell(
                                    true,
                                    "Propiedad",
                                    propiedades.getCelda(),
                                    propiedades.getNombre(),
                                    0,
                                    0,
                                    propiedades.getPrecio_compra(),
                                    propiedades.getValor_hipotecario(),
                                    propiedades.getProvincia(),
                                    null,
                                    false,
                                    propiedades.getPrecio_mejora(),
                                    propiedades.getAlquiler_base(),
                                    propiedades.getAlquiler_1chacra(),
                                    propiedades.getAlquiler_2chacra(),
                                    propiedades.getAlquiler_3chacra(),
                                    propiedades.getAlquiler_4chacra(),
                                    propiedades.getAlquiler_1estancia()
                            );
                            board.put(idCelda, cell);
                            propertyManager.addProperty((Property) cell);
                        }
                    }
                    break;
                case 2:
                    FabricaCell fabricaCellSuerte = new FabricaCellSuerte();
                    cell = fabricaCellSuerte.createCell(false, "Suerte", celdas.getId_celda(), "Celda Suerte", 0, 0, 0, 0, null, null, false, 0, 0, 0, 0, 0, 0, 0);
                    board.put(idCelda, cell);
                    break;
                case 3:
                    FabricaCell fabricaCellDestino = new FabricaCellTarget();
                    cell = fabricaCellDestino.createCell(false, "Destino", celdas.getId_celda(), "Celda Destino", 0, 0, 0, 0, null, null, false, 0, 0, 0, 0, 0, 0, 0);
                    board.put(idCelda, cell);
                    break;
                case 4:
                    cell = new Especial(idCelda,false,"premio",celdas.getId_celda(),"Premio");
                    board.put(idCelda, cell);
                    break;
                case 5:
                    cell = new Especial(idCelda,false,"salida",celdas.getId_celda(),"Salida");
                    board.put(idCelda, cell);
                    break;
                case 6:
                    cell = new Especial(idCelda,false,"impuesto",celdas.getId_celda(),"Impuesto");
                    board.put(idCelda, cell);
                    break;
                case 7:
                    for(Posesiones posesiones: gameData.getPosesiones()) {

                        if (posesiones.getCelda()==idCelda) {

                            FabricaCell fabricaCell = new FabricaCellRailway();
                            cell = fabricaCell.createCell(
                                    true,
                                    "Ferrocarril",
                                    posesiones.getCelda(),
                                    posesiones.getNombre(),
                                    0,
                                    0,
                                    posesiones.getPrecio_compra(),
                                    0,
                                    null,
                                    null,
                                    false,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0
                            );
                            board.put(idCelda, cell);

                        }

                    }
                    break;
                case 8:
                    for(Posesiones posesiones: gameData.getPosesiones()) {
                        if (posesiones.getCelda()==idCelda){
                            FabricaCell fabricaCell = new FabricaCellCompany();
                            cell = fabricaCell.createCell(
                                    true,
                                    "Compañia",
                                    posesiones.getCelda(),
                                    posesiones.getNombre(),
                                    0,
                                    0,
                                    posesiones.getPrecio_compra(),
                                    0,
                                    null,
                                    null,
                                    false,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0
                            );
                            board.put(idCelda, cell);
                        }

                    }
                    break;
                case 9:
                    cell = new Especial(idCelda,false,"comisaria",celdas.getId_celda(),"Comisaria");
                    board.put(idCelda, cell);
                    break;

                case 10:
                    cell = new Especial(idCelda,false,"marche preso",celdas.getId_celda(),"Marche Preso");
                    board.put(idCelda, cell);
                    break;

                case 11:
                    cell = new Especial(idCelda,false,"libre estacionamiento",celdas.getId_celda(),"Libre Estacionamiento");
                    board.put(idCelda, cell);
                    break;

                case 12:
                    cell = new Especial(idCelda,false,"descanso",celdas.getId_celda(),"Descanso");
                    board.put(idCelda, cell);
                    break;

                default:
                    break;
            }

        }

    }

    public static Tablero getInstance() {
        if (instance==null) {
            instance= new Tablero();
        }
        return instance;
    }

    public Cell obtenerCasilla(int posicion){
        return board.get(posicion);
    }

    public List<Player> ordering(List<Player> players) {

        Map<Player, Integer> diceResults = new HashMap<>();
        for (Player p : players) {
            Dice.getInstance().rollDice();
            int result = Dice.getInstance().sumDice();
            diceResults.put(p, result);
        }
        playerOrder = new ArrayList<>(players);

       playerOrder.sort(Comparator.comparingInt(diceResults::get).reversed());
        return playerOrder;
    }

    public void moverJugador(Player player) {

        Dice.getInstance().rollDice();

        Printer.println(colorize(player.getName()+ " rolleo: "+Dice.getInstance().getDie1()+" y "+Dice.getInstance().getDie2(), BLACK_TEXT(), WHITE_BACK(), ITALIC()));

        int nuevaCasilla= player.getPositionOnBoard()+ Dice.getInstance().sumDice();

        if (nuevaCasilla>= board.size()){
            nuevaCasilla = nuevaCasilla - 41;
            player.setMoney(player.getMoney()+5000);
        }
        if (nuevaCasilla==4||nuevaCasilla==15||nuevaCasilla==36){
            this.suerte=true;
        }

        if (nuevaCasilla==10||nuevaCasilla==25||nuevaCasilla==38){
            this.destino=true;
        }

        player.setPositionOnBoard(nuevaCasilla);

        board.get(nuevaCasilla).PlayerEntered(player);

    }
    public  Player getPlayerByName(String name){
        for( Player player : playerOrder){
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }
}
