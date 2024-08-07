package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BotEquilibradoTest {
     BotEquilibrado bot;
    private Bank banco;
    private Property property;
    @Test
    public void TestBuyProperty_PriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,15000, "Santa Fe", null, false,0,0,0,0,0,0,0);
        bot = new BotEquilibrado("Bot1");

        bot.buyProperty(new ArrayList<>(), property);

        assertEquals(25000, bot.getMoney());
        assertEquals("Bot1", property.getPlayerOwner());
    }
    @Test
    public void testBuyProperty_NotEnoughMoney() {
        bot = new BotEquilibrado("Bot1");
        bot.setMoney(5000);
        Property property = new Property(true, "casa", 1, "Casa blanca", 0, 0, 10000, 0, "Santa Fe", null, false,0,0,0,0,0,0,0);
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(0, bot.getProperties().size());
        assertEquals(5000, bot.getMoney());
        assertNull(property.getPlayerOwner());
    }
    @Test
    public void TestBuyProperty_NotPriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,0, "Cordoba", null, false,0,0,0,0,0,0,0);
        bot = new BotEquilibrado("Bot1");
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(0, bot.getProperties().size());
        assertEquals(35000, bot.getMoney());
        assertNull(property.getPlayerOwner());
    }
    @Test
    public void testBuyRailway() {
        bot = new BotEquilibrado("Bot1");
        Railway railway = new Railway(true,"Ferrocarril", 8,"tren argentino", 20000, null);
        bot.buyRailway(railway, bot.getRailways());
        assertEquals(1, bot.getRailways().size());
        assertEquals(15000, bot.getMoney());
        assertEquals("Bot1", railway.getPlayerOwner());
    }
    @Test
    public void testBuyRailway_NoMoney() {
        bot = new BotEquilibrado("Bot1");
        bot.setMoney(10000);
        Railway railway = new Railway(true,"Ferrocarril", 8,"tren argentino", 20000, null);
        bot.buyRailway(railway, bot.getRailways());
        assertEquals(0, bot.getRailways().size());
        assertEquals(10000, bot.getMoney());
        assertNull(railway.getPlayerOwner());
    }
    @Test
    public void testSellProperty() {
        Property property = new Property(true, "House", 3, "Casa Santa Fe", 0, 0, 24000, 0, "Santa Fe", "BotEquilibrado", false,0,0,0,0,0,0,0);
        List<Property> properties = new ArrayList<>();
        bot = new BotEquilibrado("Bot1");
        properties.add(property);

        Player buyer= new User("User1");


        bot.sellProperty(properties, property, buyer);

        assertEquals(0, bot.getProperties().size());
        assertEquals(59000, buyer.getMoney());
    }

    @Test
    public void testGetOutOfJailCard() {
        bot = new BotEquilibrado("Bot1");
        bot.setTarjetasSalirComisaria(1);

        boolean usedCard = bot.getOutOfJailCard();

        assertTrue(usedCard);
        assertEquals(0, bot.getTarjetasSalirComisaria());
    }
    @Test
    public void testGetOutOfJailCard_NoCard(){
        bot = new BotEquilibrado("Bot1");


        boolean usedCard = bot.getOutOfJailCard();
        assertTrue(usedCard);
        assertEquals(34000, bot.getMoney());
    }
    @Test
    public void testGetOutOfJailCard_NoMoney(){
        bot= new BotEquilibrado("bot");
        bot.setMoney(500);
        boolean usedCard = bot.getOutOfJailCard();
        assertFalse(usedCard);
    }
    @Test
    public  void testMortgageProperty(){
        bot = new BotEquilibrado("Bot1");
        Property property = new Property(true, "House", 6,"Casa violeta",0,0, 18000,15000,"Buenos Aires","Bot1", true,0,0,0,0,0,0,0);
        bot.mortgageProperty(property, bot);
        assertEquals(50000, bot.getMoney());

    }
    @Test
    void testAddImprovements_PropertyValid(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "ProvinceA", null, false, 200, 0, 0, 0, 0, 0, 0);
        banco = new Bank();
        bot = new BotEquilibrado("Bot1");


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
        bot = new BotEquilibrado("Bot1");


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
        bot = new BotEquilibrado("bot1");
        bot.addImprovements(railway, banco);

    }
}



