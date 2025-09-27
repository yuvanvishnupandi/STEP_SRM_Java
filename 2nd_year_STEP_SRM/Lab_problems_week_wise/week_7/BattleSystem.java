// File: BattleSystem.java
// PROBLEM 3: Gaming Character System - Dynamic Method Dispatch

abstract class Character {
    protected String name;
    public Character(String name) { this.name = name; }
    public abstract void attack(); // behavior decided at runtime
}

class Warrior extends Character {
    public Warrior(String name) { super(name); }
    @Override
    public void attack() {
        System.out.println(name + " swings a sword! High defense boost.");
    }
}

class Mage extends Character {
    private int mana;
    public Mage(String name, int mana) { super(name); this.mana = mana; }
    @Override
    public void attack() {
        System.out.println(name + " casts a fireball! Uses " + Math.min(10, mana) + " mana.");
    }
}

class Archer extends Character {
    public Archer(String name) { super(name); }
    @Override
    public void attack() {
        System.out.println(name + " shoots a long-range arrow!");
    }
}

public class BattleSystem {
    public static void main(String[] args) {
        Character[] army = {
            new Warrior("Thorin"),
            new Mage("Elly", 30),
            new Archer("Robin")
        };

        for (Character c : army) {
            c.attack(); // runtime dispatch chooses correct method
        }
    }
}
