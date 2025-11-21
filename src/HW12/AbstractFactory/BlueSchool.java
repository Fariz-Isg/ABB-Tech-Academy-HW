package HW12.AbstractFactory;

public class BlueSchool implements MagicSchool {
    public Spell createOffensiveSpell() {
        return new IceShardSpell();
    }

    public Potion createRecoveryPotion() {
        return new ManaPotion();
    }
}
