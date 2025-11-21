package HW12.ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String base;
    private List<String> ingredients;
    private int sweetness;
    private int creaminess;
    private boolean special;
    private boolean extraFancy;

    public Coffee() {
        this.base = "espresso";
        this.ingredients = new ArrayList<>();
        this.sweetness = 0;
        this.creaminess = 0;
        this.special = false;
        this.extraFancy = false;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void increaseSweetness(int amount) {
        sweetness += amount;
    }

    public void increaseCreaminess(int amount) {
        creaminess += amount;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public void setExtraFancy(boolean extraFancy) {
        this.extraFancy = extraFancy;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getSweetness() {
        return sweetness;
    }

    public int getCreaminess() {
        return creaminess;
    }
}
