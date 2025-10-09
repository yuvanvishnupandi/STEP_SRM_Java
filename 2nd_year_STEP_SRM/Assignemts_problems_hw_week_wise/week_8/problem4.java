Topic 4: Interface Inheritance (Extending Interface)

// File: Animal.java
public interface Animal {
    void eat();
}

// File: Pet.java
public interface Pet extends Animal {
    void play();
}

// File: Dog.java
public class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing fetch.");
    }
}

// File: AnimalTest.java
public class AnimalTest {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}
