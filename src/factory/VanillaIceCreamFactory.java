package factory;

import model.IceCream;
import model.Flavour;

import java.util.List;

public class VanillaIceCreamFactory implements IceCreamFactory {

    @Override
    public IceCream prepareIceCream() {
        return new IceCream(
                Flavour.VANILLA.getFlavour(),
                3.52,
                List.of("Milk", "Sugar", "Cream", "Vanilla extract"),
                List.of("Dairy"));
    }
}
