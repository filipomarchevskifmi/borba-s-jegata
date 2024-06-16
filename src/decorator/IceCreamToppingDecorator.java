package decorator;

import model.IceCream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class IceCreamToppingDecorator extends IceCream {

    protected final IceCream iceCream;

    protected IceCreamToppingDecorator(String flavour, double price, List<String> ingredients, List<String> allergens, IceCream iceCream) {
        super(flavour, price, ingredients, allergens);
        this.iceCream = iceCream;
    }

    @Override
    public String getFlavour() {
        if (!Objects.isNull(iceCream)) {
            return iceCream.getFlavour();
        } else {
            return "Just a topping";
        }
    }

    @Override
    public double getPrice() {
        if (!Objects.isNull(iceCream)) {
            return price + iceCream.getPrice();
        } else {
            return price;
        }
    }

    @Override
    public List<String> getIngredients() {
        if (!Objects.isNull(iceCream)) {
            return Stream.concat(ingredients.stream(), iceCream.getIngredients().stream())
                    .toList();
        } else {
            return ingredients;
        }
    }

    @Override
    public List<String> getAllergens() {
        if (!Objects.isNull(iceCream)) {
            return Stream.concat(allergens.stream(), iceCream.getAllergens().stream())
                    .toList();
        } else {
            return allergens;
        }
    }
}
