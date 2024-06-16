import decorator.ChocolateGlazeDecorator;
import decorator.ChocolateSprinklesDecorator;
import decorator.IceCreamToppingDecorator;
import factory.AbstractIceCreamFactory;
import model.Flavour;
import model.IceCream;
import model.Topping;

import java.util.List;
import java.util.Objects;

public final class PastryShop {

    private static PastryShop pastryShop;

    public static PastryShop getInstance() {
        if (Objects.isNull(pastryShop)) {
            pastryShop = new PastryShop();
        }
        return pastryShop;
    }

    private final AbstractIceCreamFactory abstractIceCreamFactory = AbstractIceCreamFactory.getInstance();

    private PastryShop() {

    }

    public IceCream sellIceCream(Flavour flavour, List<Topping> toppings) {
        IceCream iceCream = abstractIceCreamFactory.prepareIceCream(flavour);
        return addToppings(toppings, iceCream);
    }

    private IceCream addToppings(List<Topping> toppings, IceCream iceCream) {
        if (toppings.isEmpty()) {
            return iceCream;
        } else {
            return constructToppingDecorator(toppings, iceCream);
        }
    }

    private IceCream constructToppingDecorator(List<Topping> toppings, IceCream iceCream) {
        IceCreamToppingDecorator iceCreamToppingDecorator = null;
        for (int i = 0; i < toppings.size(); i++) {
            if (i == 0) {
                iceCreamToppingDecorator = constructToppingDecorator(toppings.get(i), iceCream);
            } else {
                iceCreamToppingDecorator = constructToppingDecorator(toppings.get(i), iceCreamToppingDecorator);
            }
        }
        return iceCreamToppingDecorator;
    }

    private IceCreamToppingDecorator constructToppingDecorator(Topping topping, IceCream iceCream) {
        return switch (topping) {
            case CHOCOLATE_GLAZE -> new ChocolateGlazeDecorator(iceCream);
            case CHOCOLATE_SPRINKLES -> new ChocolateSprinklesDecorator(iceCream);
        };
    }
}
