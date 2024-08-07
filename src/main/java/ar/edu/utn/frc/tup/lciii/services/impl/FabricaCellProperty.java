package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.model.Deck;
import ar.edu.utn.frc.tup.lciii.model.Property;
import ar.edu.utn.frc.tup.lciii.model.Cell;

public class FabricaCellProperty extends  FabricaCell{
    @Override
    public Cell createCell(boolean purchasable, String type, int number, String name, int chacras, int residence, int value, int mortgageValue, String province, String playerOwner, boolean isBusy, int precio_mejora, int alquiler_base, int alquiler_1chacra, int alquiler_2chacra, int alquiler_3chacra, int alquiler_4chacra, int alquiler_1estancia) {
        return new Property(purchasable, type, number, name, chacras, residence, value, mortgageValue, province, playerOwner, isBusy, precio_mejora, alquiler_base, alquiler_1chacra, alquiler_2chacra, alquiler_3chacra, alquiler_4chacra, alquiler_1estancia);
    }
}
