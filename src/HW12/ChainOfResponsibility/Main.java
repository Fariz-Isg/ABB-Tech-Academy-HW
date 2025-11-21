package HW12.ChainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static void main() {
        CoffeeHandler sugar = new SugarHandler();
        CoffeeHandler milk = new MilkHandler();
        CoffeeHandler flavor = new FlavorHandler();
        CoffeeHandler cream = new CreamHandler();

        sugar.setNext(milk).setNext(flavor).setNext(cream);

        Map<String, Object> order1 = new HashMap<>();
        order1.put("sugar", 1);
        order1.put("milk", "oat milk");
        Coffee coffee1 = sugar.process(new Coffee(), order1);
        System.out.println("\nSimple Coffee: " + String.join(", ", coffee1.getIngredients()));
        System.out.println("   Stats: Sweetness=" + coffee1.getSweetness() + ", Creaminess=" + coffee1.getCreaminess());

        Map<String, Object> order2 = new HashMap<>();
        order2.put("milk", "whole milk");
        order2.put("flavor", "vanilla");
        order2.put("whipped_cream", true);
        Coffee coffee2 = sugar.process(new Coffee(), order2);
        System.out.println("\nFancy Latte: " + String.join(", ", coffee2.getIngredients()));
        System.out.println("   Stats: Sweetness=" + coffee2.getSweetness() + ", Creaminess=" + coffee2.getCreaminess());

        Map<String, Object> order3 = new HashMap<>();
        order3.put("sugar", 0);
        Coffee coffee3 = sugar.process(new Coffee(), order3);
        String ingredients = coffee3.getIngredients().isEmpty() ? "black" : String.join(", ", coffee3.getIngredients());
        System.out.println("\nBlack Coffee: " + ingredients);
        System.out.println("   Stats: Sweetness=" + coffee3.getSweetness() + ", Creaminess=" + coffee3.getCreaminess());
    }
}
