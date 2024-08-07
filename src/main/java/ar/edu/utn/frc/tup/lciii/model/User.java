package ar.edu.utn.frc.tup.lciii.model;

import java.util.List;

import ar.edu.utn.frc.tup.lciii.Printer;
import com.diogonunes.jcolor.Attribute;
import lombok.*;

import static com.diogonunes.jcolor.Ansi.colorize;

@Getter
@Setter
public class User extends Player{
    public User(String name) {
        super(name);
        this.setBot(false);
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
    public void mortgageProperty(Property property, Player player) {
        super.mortgageProperty(property, player);
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
                propCaida.setChacras(propCaida.getChacras() + 1);
                this.setMoney(this.getMoney() - propCaida.getPrecio_mejora());
                banco.getCantidadMejoras().put("Chacras", banco.getCantidadMejoras().get("Chacras") - 1);
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
            setMoney(getMoney() - 1000);
            Printer.println(this.getName() + "ha pagado para salir de la carcel");
            return true;
        }

        Printer.println(this.getName()+ "no ha podido salir de la carcel");
        return false;
    }
}
