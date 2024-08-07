package ar.edu.utn.frc.tup.lciii.services.impl;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.model.*;
import com.diogonunes.jcolor.Attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.ITALIC;
import static com.diogonunes.jcolor.Attribute.MAGENTA_TEXT;

public class BotAgresivo extends Bot {
    private List<String> PreferenciasProvincias  = List.of("Tucuman", "Cordoba", "Buenos Aires");
    private  int propertiesPurchased;


    public BotAgresivo(String Name) {
        super(Name);
    }


    public void buyRailway(Railway railway){
        if(railway.getPlayerOwner() == null) {
            if(this.getMoney() >= railway.getValue()){
            int Money=    this.getMoney() - railway.getValue() ;
            this.setMoney(Money);
            railway.setPlayerOwner(this.getName());
                this.getRailways().add(railway);
                Printer.println(this.getName() + " ha comprado con exito el ferrocaril!!");}
        }else{Printer.println(this.getName() + " no tiene dinero suficiente para pagar este ferrocaril !!");}
    }
    public void buyCompany(Company company, List<Company> companyList){
        if(company.getPlayerOwner() == null){
            if(this.getMoney() >=  company.getValue()){
                setMoney(this.getMoney()-company.getValue());
                company.setPlayerOwner(this.getName());
                this.getCompanies().add(company);
                Printer.println(this.getName() + " ha comprado con exito la compania!!");
            } else{Printer.println(this.getName() + " no tiene dinero suficiente para pagar esta compania!!");}
        }
    }

public boolean propertyDisponibles(){
        PropertyManager propertyManager = PropertyManager.getInstance();
        List<Property> allProperties = propertyManager.getAllProperties();
    for(String province : PreferenciasProvincias) {
        boolean propertySold = false;
        for(Property property : allProperties) {
            if(property.getProvince().equals(province) && property.getPlayerOwner() != null) {
                propertySold = true;
                break;
            }
        }
        if(!propertySold) {
            return false;
        }
    }
    return true;

}
public boolean propertyCompletadas(){

    for( String province : PreferenciasProvincias) {
        boolean ownsPropertyInProvince = false;
        for(Property property : this.getProperties()) {
            if(property.getProvince().equals(province)) {
                ownsPropertyInProvince = true;
                break;
            }
        }
        if(!ownsPropertyInProvince) {
            return false;
        }
    }
 return true;
}

    @Override
    public void buyProperty(List<Property> properties, Property property) {
        if(this.getMoney() >= property.getValue()){
            boolean isPriorityProvince = PreferenciasProvincias.contains(property.getProvince());
           if(property.getPlayerOwner() == null) {
               if (isPriorityProvince || propertyCompletadas() || propertyDisponibles() ) {

                   properties.add(property);
                   this.setMoney(this.getMoney() - property.getValue());
                   if (!isPriorityProvince) {
                       propertiesPurchased = 0;
                   } else {
                       propertiesPurchased++;
                   }
                   property.setPlayerOwner(this.getName());
                   Printer.println(colorize(getName()+" ha comprado la propiedad de la provincia "+ property.getProvince()+": "+property.getName()+" su precio de compra es: " +property.getValue()+" y el dinero restante del jugador: "+getMoney()+"$",MAGENTA_TEXT(),ITALIC()));
               } else{
                   Printer.println("El "+ getName() + " ha decidido no comprar la propiedad");
               }
           } else{
               Printer.println("Esta propiedad ya tiene dueno");
           }

        }else {Printer.println(this.getName() + " no tiene dinero suficiente para comprar la propiedad!!");}
    }

    @Override
    public void sellProperty(List<Property> properties, Property property, Player player) {
        for (Property prop : properties){
            if (prop.equals(property)){
                int propertyPrice = property.getValue();
                player.setMoney(propertyPrice + player.getMoney());
                properties.remove(prop);
                property.setPlayerOwner(player.getName());
                Printer.println("Ha vendido la propiedad el bot " + this.getName());
                break;

            }
        }
    }
    @Override
    public void sellRailway(List<Railway> railways, Railway railway, Player player ){
        Printer.println("El bot " + this.getName() +" ha decido no vender ninguno de sus ferrocarriles");
    }
    @Override
    public void sellCompany(List<Company> companies, Company company, Player player ){
        Printer.println("El bot " + this.getName() +" ha decido no vender ninguna de sus companias");
    }
    @Override
    public void mortgageProperty(Property property, Player player) {
        int priceMortage = property.getMortgageValue();
        player.setMoney(priceMortage + getMoney());
    }

    @Override
    public void addImprovements(Cell propiedadCaida, Bank banco) {
        if (propiedadCaida instanceof Property propCaida){
            int count = 0;
            for (Property property : this.getProperties()){
                if (this.getProperties().contains(propiedadCaida)){
                    if (property.getProvince().equals(propCaida.getProvince())){
                        count++;
                    }
                }
                else{
                    Printer.println(colorize("Esta propiedad no lo tiene comprada", Attribute.BLACK_TEXT(), Attribute.RED_BACK(), Attribute.ITALIC()));
                }
            }
            if (count >= 2){
                if (propCaida.getPrecio_mejora() < ((85*this.getMoney())/100)){
                    propCaida.setChacras(propCaida.getChacras() + 1);
                    this.setMoney(this.getMoney() - propCaida.getPrecio_mejora());
                    banco.getCantidadMejoras().put("Chacras", banco.getCantidadMejoras().get("Chacras") - 1);
                }else {
                    Printer.println(colorize("Supera el 85% de mi dinero, no lo compro!", Attribute.BLACK_TEXT(), Attribute.RED_BACK(), Attribute.ITALIC()));
                }
            }
            else{
                Printer.println(colorize("Falta comprar propiedades en la provincia", Attribute.BLACK_TEXT(), Attribute.RED_BACK(), Attribute.ITALIC()));
            }
        }
        else {
            Printer.println(colorize("Esta no es una casilla de Propiedad", Attribute.BLACK_TEXT(), Attribute.RED_BACK(), Attribute.ITALIC()));
        }
    }

    @Override
    public boolean getOutOfJailCard() {
        if(this.getTarjetasSalirComisaria() >= 1){
            this.setTarjetasSalirComisaria(this.getTarjetasSalirComisaria()-1);
            Printer.println("El jugador "+ this.getName() +" uso la carta para salir de la carcel!!");
            return true;
        } else if (this.getMoney() > 1000){

            Bank.takeMoney(this, 1000);
            Printer.println(this.getName() + " ha pagado para salir de la carcel");
            return true;
        }

         Printer.println(this.getName()+ "no ha podido salir de la carcel");
            return false;
    }
}
