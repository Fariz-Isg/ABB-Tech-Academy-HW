package HW12.AbstractFactory;

public class Main {
    static void main() {
        System.out.println("Red in battle:");
        battle(new RedSchool());

        System.out.println("\nBlue in battle:");
        battle(new BlueSchool());
    }

    private static void battle(MagicSchool school) {
        Spell spell = school.createOffensiveSpell();
        Potion potion = school.createRecoveryPotion();
        System.out.println(spell.act());
        System.out.println(potion.consume());
    }
}
