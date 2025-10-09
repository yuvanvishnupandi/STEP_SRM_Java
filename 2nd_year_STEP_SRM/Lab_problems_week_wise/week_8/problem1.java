LAB PROBLEM 1: Abstract Fruit and Edible Interface

// File: Fruit.java
public abstract class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public abstract void showDetails();
}

// File: Edible.java
public interface Edible {
    void nutrientsInfo();
}

// File: Apple.java
public class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Rich in vitamins and fiber.");
    }
}

// File: FruitTest.java
public class FruitTest {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Kashmiri");
        apple.showDetails();
        apple.nutrientsInfo();
    }
}
