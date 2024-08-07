package ar.edu.utn.frc.tup.lciii.model;

import java.util.List;

public class Bot extends Player {

    public Bot(String name) {
        super(name);
        this.setBot(true);
    }

    public void behavior(){
        isPreferred();
        canImprove();
        improveProperty();;
        buyAnyways();
    }
    public boolean isPreferred(){
        return false;
    }
    public boolean canImprove(){return false;}
    public void improveProperty(){}
    public void buyAnyways(){}

    @Override
    public String getName() {
        return super.getName();
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
    public void sellRailway(List<Railway> railways, Railway railway, Player player ){
        super.sellRailway(railways, railway, player);
  }
    @Override
    public void sellCompany(List<Company> companies, Company company, Player player ){
        super.sellCompany(companies, company, player);
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
}
