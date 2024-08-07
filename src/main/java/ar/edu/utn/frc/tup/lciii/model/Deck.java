package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.entities.GameData;
import ar.edu.utn.frc.tup.lciii.entities.Tarjetas;
import ar.edu.utn.frc.tup.lciii.services.impl.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
@Getter
public class Deck {
    private Stack<Card> cards;
    private String type;

    public Deck(String type) {
        this.type = type;
        this.cards = new Stack<>();
        makeADeck();
        shuffle();
    }
    public void makeADeck(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        GameData gameData = null;
        try (FileReader reader = new FileReader("GameData.json")) {
            gameData = gson.fromJson(reader, GameData.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        List<Tarjetas> tarjetasList = new ArrayList<>();

        for (Tarjetas tarjetas : gameData.getTarjetas()){

            if (tarjetas.getTipo_tarjeta().equals(type)) {
                tarjetasList.add(tarjetas);
            }
        }


        FabricaTarjeta fabricaTarjeta;


        for (Tarjetas tj : tarjetasList){
            if (tj.getId_tipo_efecto()==1) {
                fabricaTarjeta = new FabricaTarjetaPago(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
            if (tj.getId_tipo_efecto()==2) {
                fabricaTarjeta = new FabricaTarjetaMover(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
            if (tj.getId_tipo_efecto()==3) {
                fabricaTarjeta = new FabricaTerjetaCobrar(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
            if (tj.getId_tipo_efecto()==4) {
                fabricaTarjeta = new FabricaTarjetaMarchePreso(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
            if (tj.getId_tipo_efecto()==5) {
                fabricaTarjeta = new FabricaTarjetaSalirComisaria(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
            if (tj.getId_tipo_efecto()==6) {
                fabricaTarjeta = new FabricaTarjetaPagoSuerte(tj);
                cards.push((Card) fabricaTarjeta.deliverCard());
            }
        }

    }

    public void addCard(Card carta) {
        cards.add(carta);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card pickCard() {
        if (cards.isEmpty()) {
            return null;
        }

        Card pickedCard = cards.pop();
        returnCardToBottom(pickedCard);
        return pickedCard;
    }

    private void returnCardToBottom(Card card) {
        cards.add(0, card);
    }

}