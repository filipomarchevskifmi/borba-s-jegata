package model;

import java.util.List;

public class IceCream {

    protected final String flavour;

    protected final double price;

    protected final List<String> ingredients;

    protected final List<String> allergens;

    public IceCream(String flavour, double price, List<String> ingredients, List<String> allergens) {
        this.flavour = flavour;
        this.price = price;
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public String getFlavour() {
        return flavour;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getAllergens() {
        return allergens;
    }
}
