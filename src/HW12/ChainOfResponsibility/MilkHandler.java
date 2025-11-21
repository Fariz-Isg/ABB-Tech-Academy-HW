package HW12.ChainOfResponsibility;

import java.util.Map;

public class MilkHandler extends CoffeeHandler{
    public Coffee process(Coffee coffee, Map<String, Object> preferences) {
        String milkType = (String) preferences.get("milk");
        if (milkType != null) {
            coffee.addIngredient(milkType);
            coffee.increaseCreaminess(3);
        }
        return super.process(coffee, preferences);
    }
}
