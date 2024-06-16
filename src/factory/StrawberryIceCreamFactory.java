package factory;

import model.IceCream;
import model.Flavour;

import java.util.List;

public class StrawberryIceCreamFactory implements IceCreamFactory {

    @Override
    public IceCream prepareIceCream() {
        return new IceCream(
                Flavour.STRAWBERRY.getFlavour(),
                6.31,
                List.of("Milk", "Sugar", "Cream", "Strawberries"),
                List.of("Dairy", "Strawberries"));
    }
}
