import model.IceCream;

import java.util.List;

import static model.Flavour.*;
import static model.Topping.CHOCOLATE_GLAZE;
import static model.Topping.CHOCOLATE_SPRINKLES;

public class Main {

    public static void main(String[] args) {
        PastryShop pastryShop = PastryShop.getInstance();
        IceCream chocolateIceCreamWithoutToppings = pastryShop.sellIceCream(CHOCOLATE, List.of());
        IceCream strawberryIceCreamWithSprinklesAndGlaze = pastryShop.sellIceCream(STRAWBERRY, List.of(CHOCOLATE_SPRINKLES, CHOCOLATE_GLAZE));
        IceCream vanillaIceCreamWithGlaze = pastryShop.sellIceCream(VANILLA, List.of(CHOCOLATE_GLAZE));

        List.of(chocolateIceCreamWithoutToppings, strawberryIceCreamWithSprinklesAndGlaze, vanillaIceCreamWithGlaze)
                .forEach(iceCream -> {
                    System.out.println(iceCream.getFlavour());
                    System.out.println(iceCream.getPrice());
                    System.out.println(iceCream.getIngredients());
                    System.out.println(iceCream.getAllergens());
                });
    }
}