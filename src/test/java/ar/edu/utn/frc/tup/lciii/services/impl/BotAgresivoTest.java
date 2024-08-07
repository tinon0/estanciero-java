package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BotAgresivoTest {
    BotAgresivo bot;
    private Player player;
    private Property property;
    private  Bank banco;
    private PropertyManager propertyManager;
    @Test
    public void TestBuyProperty_PriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,15000, "Cordoba", null, false,0,0,0,0,0,0,0);
        bot = new BotAgresivo("Bot1");

        bot.buyProperty(new ArrayList<>(), property);

        assertEquals(25000, bot.getMoney());
        assertEquals("Bot1", property.getPlayerOwner());
    }
    @Test
    public void TestBuyProperty_NotPriorityProvince(){
        Property property = new Property(true, "casa", 1,"Casa blanca", 0,0,10000,0, "Formosa", null, false,0,0,0,0,0,0,0);
        bot = new BotAgresivo("Bot1");
        bot.buyProperty(new ArrayList<>(), property);
        assertEquals(0, bot.getProperties().size());
        assertEquals(35000, bot.getMoney());
        assertNull(property.getPlayerOwner());
    }
    @Test
    public void testSellProperty() {
        player = new User("Player1");
        bot = new BotAgresivo("Bot1");
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
public void testBuyRailway_Money(){
    Railway railway = new Railway(true,"railway",7,"tren argentino",20000, null);
    bot = new BotAgresivo("Bot1");
    bot.buyRailway(railway);
    assertEquals(15000, bot.getMoney());
    assertEquals("Bot1", railway.getPlayerOwner());
}
    @Test
    public void testBuyRailway_NoMoney(){
        Railway railway = new Railway(true,"railway",7,"tren argentino",20000, null);
        bot = new BotAgresivo("Bot1");
        bot.setMoney(10000);
        bot.buyRailway(railway);
        assertEquals(10000, bot.getMoney());
        assertNull( railway.getPlayerOwner());
    }

    @Test
    public void testGetOutOfJailCard() {
        bot = new BotAgresivo("Bot1");
        bot.setTarjetasSalirComisaria(1);

        boolean usedCard = bot.getOutOfJailCard();

        assertTrue(usedCard);
        assertEquals(0, bot.getTarjetasSalirComisaria());
    }
    @Test
    void testPropertyDisponibles_SomeAvailable() {
        Property property1 = new Property(true, "House", 1, "Casa1", 0, 0, 20000, 15000, "Tucuman", "Player1", false,0,0,0,0,0,0,0);
        Property property2 = new Property(true, "House", 2, "Casa2", 0, 0, 25000, 18000, "Cordoba", "Player2", false,0,0,0,0,0,0,0);
        Property property3 = new Property(true, "House", 3, "Casa3", 0, 0, 30000, 20000, "Buenos Aires", "Player3", false,0,0,0,0,0,0,0);
        bot = new BotAgresivo("Bot1");
        propertyManager = mock(PropertyManager.class);




        List<Property> properties = Arrays.asList(property1, property2, property3);
        when(propertyManager.getAllProperties()).thenReturn(properties);

        boolean disponibles = bot.propertyDisponibles();

        assertFalse(disponibles);
    }
    @Test
    public void testBuyCompany(){
        bot = new BotAgresivo("Bot1");
        Company company = new Company( true,"Company", 5,"Comapny1",10000,null );
        bot.buyCompany(company, bot.getCompanies());
        assertEquals(25000, bot.getMoney());
        assertEquals("Bot1", company.getPlayerOwner());
        assertTrue(bot.getCompanies().contains(company));
    }
    @Test
    public void testBuyCompany_NotMoney(){
        bot = new BotAgresivo("Bot1");
        Company company = new Company( true,"Company", 5,"Comapny1",10000,null );
        bot.setMoney(7000);
        bot.buyCompany(company, bot.getCompanies());

        assertEquals(7000, bot.getMoney());
        assertNull(company.getPlayerOwner());
        assertFalse(bot.getCompanies().contains(company));
    }
    @Test
    public void testGetOutOfJailCard_NoCard(){
        bot = new BotAgresivo("Bot1");
        bot.setMoney(35000);


        boolean usedCard = bot.getOutOfJailCard();
        assertTrue(usedCard);

        assertEquals(34000, bot.getMoney());
    }
    @Test
    public void testGetOutOfJailCard_NoMoney(){
        bot= new BotAgresivo("bot");
        bot.setMoney(500);
        boolean usedCard = bot.getOutOfJailCard();
        assertFalse(usedCard);
    }
    @Test
    public  void testMortgageProperty(){
        bot = new BotAgresivo("Bot1");
        Property property = new Property(true, "House", 6,"Casa violeta",0,0, 18000,15000,"Buenos Aires","Bot1", true,0,0,0,0,0,0,0);
        bot.mortgageProperty(property, bot);
        assertEquals(50000, bot.getMoney());

    }
    @Test
    public void testBuyCompany_AlreadyOwned() {
        bot = new BotAgresivo("Bot1");
        Company company = new Company(true,"Company1", 2, "Company1", 12000, "Player2");

        bot.buyCompany(company, bot.getCompanies());

        assertEquals(35000, bot.getMoney());
        assertEquals("Player2", company.getPlayerOwner());
        assertFalse(bot.getCompanies().contains(company));
    }
    @Test
    void testAddImprovements_PropertyValid(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "ProvinceA", null, false, 200, 0, 0, 0, 0, 0, 0);
        banco = new Bank();
        bot = new BotAgresivo("Bot1");


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
        bot = new BotAgresivo("Bot1");


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
       bot = new BotAgresivo("bot1");
       bot.addImprovements(railway, banco);

    }


}


