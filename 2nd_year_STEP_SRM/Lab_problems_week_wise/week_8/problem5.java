LAB PROBLEM 5: Abstract Animal and Soundable Interface

// File: Animal.java
public abstract class Animal {
    protected String name;
    protected String habitat;

    public Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public abstract void eat();
}

// File: Soundable.java
public interface Soundable {
    void makeSound();
}

// File: Dog.java
public class Dog extends Animal implements Soundable {
    public Dog(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    public void eat() {
        System.out.println(name + " eats bones.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks loudly!");
    }
}

// File: AnimalTest.java
public class AnimalTest {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "House");
        d.eat();
        d.makeSound();
    }
}
