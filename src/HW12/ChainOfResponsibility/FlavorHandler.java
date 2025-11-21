package HW12.ChainOfResponsibility;

import java.util.Map;

public class FlavorHandler extends CoffeeHandler {
    public Coffee process(Coffee coffee, Map<String, Object> preferences) {
        String flavor = (String) preferences.get("flavor");
        if (flavor != null) {
            coffee.addIngredient(flavor + " syrup");
            coffee.setSpecial(true);
        }
        return super.process(coffee, preferences);
    }
}
