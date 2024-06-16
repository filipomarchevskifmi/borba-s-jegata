package factory;

import model.IceCream;
import model.Flavour;

import java.util.List;

public class ChocolateIceCreamFactory implements IceCreamFactory {

    @Override
    public IceCream prepareIceCream() {
        return new IceCream(
                Flavour.CHOCOLATE.getFlavour(),
                5.32,
                List.of("Milk", "Cocoa powder", "Sugar", "Chocolate syrup"),
                List.of("Dairy", "Nuts"));
    }
}
