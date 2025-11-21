package HW12.AbstractFactory;

public class RedSchool implements  MagicSchool {
    public Spell createOffensiveSpell() {
        return new FireballSpell();
    }

    public Potion createRecoveryPotion() {
        return new HealthPotion();
    }

}
