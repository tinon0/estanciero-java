package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.model.*;

import java.util.List;

public interface PlayerInterface {

    // ABSTRACT METHODS
    void buyProperty(List<Property> properties, Property property);
    void sellProperty(List<Property> properties, Property property, Player player);
    void mortgageProperty(Property property, Player player);
    void buyRailway (Railway railway, List<Railway> railwayList);
    void buyCompany(Company company, List<Company> companyList);
    void sellRailway(List<Railway> railways, Railway railway, Player player );
    void sellCompany(List<Company> companies, Company company, Player player );
    void addImprovements(ar.edu.utn.frc.tup.lciii.model.Cell propiedadCaida, Bank banco);
    boolean getOutOfJailCard();
}
