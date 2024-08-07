package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Company;
import ar.edu.utn.frc.tup.lciii.model.Player;
import ar.edu.utn.frc.tup.lciii.model.Property;
import ar.edu.utn.frc.tup.lciii.model.Railway;
import ar.edu.utn.frc.tup.lciii.model.*;
import ar.edu.utn.frc.tup.lciii.services.PlayerInterface;

import java.util.List;

public class PlayerServiceImpl implements PlayerInterface {

    @Override
    public void buyProperty(List<Property> properties, Property property) {
        properties.add(property);
    }

    @Override
    public void sellProperty(List<Property> properties, Property property, Player player) {
        for (Property prop : properties) {
            if (prop.equals(property)) {
                int propertyPrice = property.getValue();
                player.setMoney(player.getMoney() + propertyPrice);
                properties.remove(prop);
                break;
            }
        }
    }

    @Override
    public void mortgageProperty(Property property, Player player) {
        int priceMortage = property.getMortgageValue();
        player.setMoney(player.getMoney() + priceMortage);
    }

    @Override
    public void buyRailway(Railway railway, List<Railway> railwayList) {
        railwayList.add(railway);
    }

    @Override
    public void buyCompany(Company company, List<Company> companyList) {
        companyList.add(company);
    }

    @Override
    public void sellRailway(List<Railway> railways, Railway railway, Player player) {
        for (Railway railw : railways) {
            if (railw.equals(railway)) {
                int RailwayPrice = railway.getValue();
                player.setMoney(player.getMoney() + RailwayPrice);
                railways.remove(railw);
                break;
            }
        }
    }

    @Override
    public void sellCompany(List<Company> companies, Company company, Player player) {
        for (Company comp : companies) {
            if (comp.equals(company)) {
                int companyPrice = company.getValue();
                player.setMoney(player.getMoney() + companyPrice);
                companies.remove(comp);
                break;
            }
        }
    }

    @Override
    public void addImprovements(Cell propiedadCaida, Bank banco) {
    }

    @Override
    public boolean getOutOfJailCard() {
        return false;
    }
}
