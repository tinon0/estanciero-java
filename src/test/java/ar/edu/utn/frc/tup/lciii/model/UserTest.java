package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.model.Property;
import ar.edu.utn.frc.tup.lciii.model.User;
import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    List<Property> listProperties = new ArrayList<>();
    private  Property property;

    User objUser = new User("Agustin");


    @Test
    @DisplayName("getName")
    void getName() {
        assertEquals("Agustin", objUser.getName());
    }

    @Test
    void setName() {
        objUser.setName("Agustin");
        assertEquals("Agustin", objUser.getName());
    }

    @Test
    void getMoney() {
        assertEquals(35000,objUser.getMoney());
    }

    @Test
    void setMoney() {
        objUser.setMoney(2000);
        assertEquals(2000,objUser.getMoney());
    }

    @Test
    void getPositionOnBoard() {
        assertEquals(0,objUser.getPositionOnBoard());
    }

    @Test
    void setPositionOnBoard() {
        objUser.setPositionOnBoard(5);
        assertEquals(5,objUser.getPositionOnBoard());
    }

    @Test
    void getProperties() {
        assertEquals(listProperties,objUser.getProperties());
    }

    @Test
    void setProperties() {
        objUser.setProperties(listProperties);
        assertEquals(listProperties,objUser.getProperties());
    }

    @Test
    void getRailRoadQuantity() {
        assertEquals(0,objUser.getRailways().size());
    }


    @Test
    void setRailRoadQuantity() {
        objUser.setRailways(new ArrayList<>());
        assertEquals(0,objUser.getRailways().size());
    }

    @Test
    void getCompaniesQuantity() {
        assertEquals(0,objUser.getCompanies().size());
    }

    @Test
    void setCompaniesQuantity() {
        objUser.setCompanies(new ArrayList<>());
        assertEquals(0,objUser.getCompanies().size());
    }

    @Test
    void buyProperty() {
        objUser.buyProperty(new ArrayList<Property>(), new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0));
    }

    @Test
    void sellProperty() {
        objUser.sellProperty(new ArrayList<Property>(), new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0), new User("nombre"));
    }

    @Test
    void mortgageProperty() {
        objUser.mortgageProperty(new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0), new User("nombre"));
    }

    @Test
    void addImprovementsFail() {
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "", null, false,0,0,0,0,0,0,0);
        Bank banco = new Bank();
        objUser.getProperties().add(property);
        objUser.addImprovements(property,banco);
        assertEquals(0,property.getChacras());
        assertEquals(35000, objUser.getMoney());
        assertEquals(32, banco.getCantidadMejoras().get("Chacras").intValue());



    }
    @Test
    void addImprovementsSuccess(){
        property = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "Formosa", null, false,100,0,0,0,0,0,0);
       Property property2 = new Property(true, "Type", 1, "Nombre", 0, 0, 0, 0, "Formosa", null, false,0,0,0,0,0,0,0);

        Bank banco = new Bank();
        objUser.getProperties().add(property);
        objUser.getProperties().add(property2);
        objUser.addImprovements(property,banco);
        assertEquals(1, property.getChacras());
        assertEquals(34900, objUser.getMoney());
        assertEquals(31, banco.getCantidadMejoras().get("Chacras").intValue());
    }

    @Test
    public void testBuyCompany_NotMoney(){
        objUser = new User("test");
        Company company = new Company( true,"Company", 5,"Comapny1",10000,null );
        objUser.setMoney(7000);
        objUser.buyCompany(company, objUser.getCompanies());

        assertEquals(7000, objUser.getMoney());
        assertNull(company.getPlayerOwner());
        assertTrue(objUser.getCompanies().contains(company));
    }
    @Test
    public void testGetOutOfJailCard_NoCard(){
        objUser = new User("test");
        objUser.setMoney(35000);


        boolean usedCard = objUser.getOutOfJailCard();
        assertTrue(usedCard);

        assertEquals(34000, objUser.getMoney());
    }
    @Test
    public void testGetOutOfJailCard_NoMoney(){
        objUser = new User("test");
        objUser.setMoney(500);
        boolean usedCard = objUser.getOutOfJailCard();
        assertFalse(usedCard);
    }
    @Test
    public void testGetOutOfJailCard() {
        objUser = new User("test");
        objUser.setTarjetasSalirComisaria(1);

        boolean usedCard = objUser.getOutOfJailCard();

        assertTrue(usedCard);
        assertEquals(0, objUser.getTarjetasSalirComisaria());
    }
}