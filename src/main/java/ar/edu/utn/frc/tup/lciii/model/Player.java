package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.services.impl.PlayerServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public abstract class Player extends PlayerServiceImpl {

    private String name;
    private int money;
    private int positionOnBoard;
    private List<Property> properties;
    private List<Railway> railways;
    private List<Company> companies;
    private  int bancarrota;
    private int tarjetasSalirComisaria;
    private boolean isBot;
    private boolean isStill;
    private boolean lose;


    public Player(String name ) {
        this.name = name;
        this.money = 35000;
        this.bancarrota = 2500;
        this.positionOnBoard = 0;
        this.properties = new ArrayList<Property>();
        this.railways = new ArrayList<Railway>();
        this.companies = new ArrayList<Company>();
        this.tarjetasSalirComisaria = 0;
        this.lose = false;
        this.isStill = false;
    }

    @Override
    public void buyProperty(List<Property> properties, Property property) {
        super.buyProperty(properties, property);
    }

    @Override
    public void sellProperty(List<Property> properties, Property property, Player player) {
        super.sellProperty(properties, property, player);
    }
    @Override
    public void buyRailway(Railway railway,  List<Railway> railwayList) {
       super.buyRailway(railway, railwayList);
    }

    @Override
    public void buyCompany(Company company, List<Company> companyList) {
        super.buyCompany(company, companyList);
    }

    @Override
    public void mortgageProperty(Property property, Player player) {
        super.mortgageProperty(property, player);
    }

    @Override
    public void addImprovements(Cell propiedadCaida, Bank banco) {
        super.addImprovements(propiedadCaida, banco);
    }

    @Override
    public boolean getOutOfJailCard() {
        return super.getOutOfJailCard();
    }

    public boolean isImmobile() {
        return isStill;
    }
}
