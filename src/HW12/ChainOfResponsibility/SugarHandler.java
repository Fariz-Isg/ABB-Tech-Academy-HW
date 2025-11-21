package HW12.ChainOfResponsibility;

import java.util.Map;

public class SugarHandler extends CoffeeHandler {
    public Coffee process(Coffee coffee, Map<String, Object> preferences) {
        Integer sugar = (Integer) preferences.get("sugar");
        if (sugar != null && sugar > 0) {
            coffee.addIngredient(sugar + " sugar cubes");
            coffee.increaseSweetness(sugar * 2);
        }
        return super.process(coffee, preferences);
    }
}
