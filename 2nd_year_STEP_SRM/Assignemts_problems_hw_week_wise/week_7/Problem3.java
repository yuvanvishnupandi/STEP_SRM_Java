// 🧪 PROBLEM 3: Gaming Character System
// Concept: Dynamic Method Dispatch

class Character {
    String name;
    Character(String name){ this.name = name; }
    void attack() { System.out.println(name + " attacks generically"); }
}

class Warrior extends Character {
    Warrior(String name){ super(name); }
    @Override
    void attack() { System.out.println(name + " swings a sword!"); }
}

class Mage extends Character {
    Mage(String name){ super(name); }
    @Override
    void attack() { System.out.println(name + " casts a fireball!"); }
}

class Archer extends Character {
    Archer(String name){ super(name); }
    @Override
    void attack() { System.out.println(name + " shoots an arrow!"); }
}

public class Problem3 {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Thor"),
            new Mage("Gandalf"),
            new Archer("Legolas")
        };

        for(Character c : army) {
            c.attack();
        }
    }
}
