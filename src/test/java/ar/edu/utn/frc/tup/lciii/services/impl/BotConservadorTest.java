package ar.edu.utn.frc.tup.lciii.services.impl;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.utn.frc.tup.lciii.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BotConservadorTest {
    BotConservador bot;
    private Player player;
    private Property property;
    private  Bank banco;
    @Test
    public void TestBuyProperty_PriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,0, "Formosa", null, false,0,0,0,0,0,0,0);
        bot = new BotConservador("Bot1");
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(1, bot.getProperties().size());
        assertEquals(25000, bot.getMoney());
        assertEquals("Bot1", property.getPlayerOwner());
    }
    @Test
    public void TestBuyProperty_NotPriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,0, "Cordoba", null, false,0,0,0,0,0,0,0);
        bot = new BotConservador("Bot1");
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(0, bot.getProperties().size());
        assertEquals(35000, bot.getMoney());
        assertNull(property.getPlayerOwner());
    }
    @Test
    public void testBuyProperty_AlreadyOwned() {
        bot = new BotConservador("Bot1");
        Property property = new Property(true, "casa", 1, "Casa blanca", 0, 0, 10000, 0, "Formosa", "Player2", false,0,0,0,0,0,0,0);
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(0, bot.getProperties().size());
        assertEquals(35000, bot.getMoney());
        assertEquals("Player2", property.getPlayerOwner());
    }
    @Test
    public void testGetOutOfJailCard() {
        bot = new BotConservador("Bot1");
        bot.setTarjetasSalirComisaria(1);

        boolean usedCard = bot.getOutOfJailCard();

        assertTrue(usedCard);

        assertEquals(0, bot.getTarjetasSalirComisaria());
    }
    @Test
    public void testGetOutOfJailCard_NoCard(){
        bot = new BotConservador("Bot1");


        boolean usedCard = bot.getOutOfJailCard();
        assertEquals(34000, bot.getMoney());
    }
    @Test
    public void testGetOutOfJailCard_NoMoney(){
        bot= new BotConservador("bot");
        bot.setMoney(500);
        boolean usedCard = bot.getOutOfJailCard();
        assertFalse(usedCard);
    }
    @Test
    public  void testMortgageProperty(){
        bot = new BotConservador("Bot1");
        Property property = new Property(true, "House", 6,"Casa violeta",0,0, 18000,15000,"Buenos Aires","Bot1", true,0,0,0,0,0,0,0);
        bot.mortgageProperty(property, bot);
        assertEquals(50000, bot.getMoney());

    }
    @Test
    public void testSellProperty() {
        player = new User("Player1");
        bot = new BotConservador("Bot1");
        property = new Property(true, "casa", 1, "Casa blanca", 0, 0, 20000, 15000, "Formosa", null, false,0,0,0,0,0,0,0);
        bot.getProperties().add(property);
        int initialMoney = player.getMoney();
        int propertyValue = property.getValue();


        bot.sellProperty(bot.getProperties(), property, player);

        assertEquals(initialMoney + propertyValue, player.getMoney());
        assertEquals(0, bot.getProperties().size());
        assertEquals("Player1", property.getPlayerOwner());
    }
    @Test
    void testAddImprovements_PropertyValid(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "ProvinceA", null, false, 200, 0, 0, 0, 0, 0, 0);
        banco = new Bank();
        bot = new BotConservador("Bot1");


        Property propiedad1 = new Property(true, "Type", 1, "Nombre1", 0, 0, 0, 0, "ProvinceA", null, false, 0, 0, 0, 0, 0, 0, 0);
        Property propiedad2 = new Property(true, "Type", 1, "Nombre2", 0, 0, 0, 0, "ProvinceA", null, false, 0, 0, 0, 0, 0, 0, 0);
        List<Property> properties = new ArrayList<>();
        properties.add(property);
        properties.add(propiedad1);
        properties.add(propiedad2);
        bot.setProperties(properties);
        bot.addImprovements(property, banco);
        assertEquals(1, property.getChacras());
        assertEquals(34800, bot.getMoney());
        assertEquals(31, banco.getCantidadMejoras().get("Chacras").intValue());

    }
    @Test
    void testAddImprovements_PropertyValid_NotEnoughMoney(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "ProvinceA", null, false, 40000, 0, 0, 0, 0, 0, 0);
        banco = new Bank();
        bot = new BotConservador("Bot1");


        Property propiedad1 = new Property(true, "Type", 1, "Nombre1", 0, 0, 0, 0, "ProvinceA", null, false, 0, 0, 0, 0, 0, 0, 0);
        Property propiedad2 = new Property(true, "Type", 1, "Nombre2", 0, 0, 0, 0, "ProvinceA", null, false, 0, 0, 0, 0, 0, 0, 0);
        List<Property> properties = new ArrayList<>();
        properties.add(property);
        properties.add(propiedad1);
        properties.add(propiedad2);
        bot.setProperties(properties);
        bot.addImprovements(property, banco);
        assertEquals(0, property.getChacras());
        assertEquals(35000, bot.getMoney());
        assertEquals(32, banco.getCantidadMejoras().get("Chacras").intValue());

    }
    @Test
    void testAddImprovements_PropertyInvalid(){
        Railway railway =new Railway(true, "tren",7,"tren", 2000,null);
        bot = new BotConservador("bot1");
        bot.addImprovements(railway, banco);

    }
}

