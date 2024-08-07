package ar.edu.utn.frc.tup.lciii.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BotTest {
    Bot bot = new Bot("Bot");
    private  Property property;


    @Test
    void buyProperty() {
        bot.buyProperty(new ArrayList<Property>(), new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false, 0,0,0,0,0,0,0));
    }

    @Test
    void sellProperty() {
        bot.sellProperty(new ArrayList<Property>(), new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0), new User("nombre"));
    }

    @Test
    void mortgageProperty() {
        bot.mortgageProperty(new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0), new User("nombre"));
    }

    @Test
    void addImprovementsFail() {
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "", null, false,0,0,0,0,0,0,0);
        Bank banco = new Bank();
        bot.getProperties().add(property);
        bot.addImprovements(property,banco);
        assertEquals(0,property.getChacras());
        assertEquals(35000, bot.getMoney());
        assertEquals(32, banco.getCantidadMejoras().get("Chacras").intValue());



    }
    @Test
    void addImprovementsSuccess(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "Formosa", null, false,100,0,0,0,0,0,0);
        Property property2 = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "Formosa", null, false,0,0,0,0,0,0,0);

        Bank banco = new Bank();
       bot.getProperties().add(property);
       bot.getProperties().add(property2);
       bot.addImprovements(property,banco);
    }

    @Test
    void getOutOfJailCard() {
        bot.getOutOfJailCard();
    }

    @Test
    void behavior() {
        bot.behavior();
    }

    @Test
    void isPreferred() {
        bot.isPreferred();
    }

    @Test
    void canImprove() {
        bot.canImprove();
    }

    @Test
    void improveProperty() {
        bot.improveProperty();
    }

    @Test
    void buyAnyways() {
        bot.buyAnyways();
    }

    @Test
    public void testGetName() {
        assertEquals("Bot", bot.getName());
    }
}