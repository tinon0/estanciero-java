package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.*;
import ar.edu.utn.frc.tup.lciii.services.impl.PlayerServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceImplTest {
    private PlayerServiceImpl service = new PlayerServiceImpl();
    private Player player;
    private Property property;
    private Railway railway;
    private Company company;

    @Test
    void buyProperty() {
        List<Property> properties = new ArrayList<>();
        Property property = new Property(true, "tipo", 2, "nombre", 1, 1,1,1, "prov", "player", false,0,0,0,0,0,0,0);
        service.buyProperty(properties, property);

        assertFalse(properties.isEmpty());
        assertEquals(1, properties.size());
    }

    @Test
    void sellProperty() {
        List<Property> properties = new ArrayList<>();
        Property property = new Property(true, "tipo", 2, "nombre", 1, 1,105,1, "prov", "player", false,0,0,0,0,0,0,0);
        User user = new User("nombre");

        service.buyProperty(properties, property);
        assertEquals(1, properties.size());

        service.sellProperty(properties, property, user);
        assertEquals(35105, user.getMoney());
        assertTrue(properties.isEmpty());

    }

    @Test
    void mortgageProperty() {
        Property property = new Property(true, "tipo", 2, "nombre", 1, 1,105,84, "prov", "player", false,0,0,0,0,0,0,0);
        User user = new User("nombre");

        service.mortgageProperty(property, user);

        assertEquals(35084, user.getMoney());
    }

    @Test
    void testBuyRailway() {
        List<Railway> railways = new ArrayList<>();
        service.buyRailway(railway, railways);
        assertEquals(1, railways.size());
        assertEquals(railway, railways.get(0));
    }

    @Test
    void testBuyCompany() {
        List<Company> companies = new ArrayList<>();
        service.buyCompany(company, companies);
        assertEquals(1, companies.size());
        assertEquals(company, companies.get(0));
    }

    @Test
    void testSellRailway() {
        List<Railway> railways = new ArrayList<>();
        player =    new User("test");
        railway = new Railway(true,"tren",7,"tren",3000,player.getName());
        railways.add(railway);

        service.sellRailway(railways, railway, player);

        assertEquals(0, railways.size());

        assertEquals(38000, player.getMoney());
    }

    @Test
    void testSellCompany() {
        player =    new User("test");
        company = new Company(true,"Company",8,"bodega", 2000, null);
        List<Company> companies = new ArrayList<>();
        companies.add(company);

        service.sellCompany(companies, company, player);
        assertEquals(0, companies.size());

        assertEquals(37000, player.getMoney());
    }
}