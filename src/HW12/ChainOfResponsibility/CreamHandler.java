package HW12.ChainOfResponsibility;

import java.util.Map;

public class CreamHandler extends CoffeeHandler{
    public Coffee process(Coffee coffee, Map<String, Object> preferences) {
        Boolean whippedCream = (Boolean) preferences.get("whipped_cream");
        if (whippedCream != null && whippedCream) {
            coffee.addIngredient("whipped cream");
            coffee.setExtraFancy(true);
        }
        return super.process(coffee, preferences);
    }
}
