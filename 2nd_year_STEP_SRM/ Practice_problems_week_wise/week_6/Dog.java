// File: Dog.java
public class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    // Constructor 1: basic dog
    public Dog() {
        super("Canine", "Domestic", 13, true, "Brown", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating default dog");
    }

    // Constructor 2: detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    // Constructor 3: copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             "CopiedFur", 60, other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty Level: " + loyaltyLevel);
    }

    public void demonstrateInheritance() {
        super.eat();
        super.move();
        super.sleep();
    }

    public static void main(String[] args) {
        // 1. default constructor
        Dog d1 = new Dog();
        d1.eat();
        d1.move();
        d1.sleep();
        d1.bark();
        d1.fetch();
        d1.showLoyalty();
        System.out.println(d1.getAnimalInfo());

        System.out.println();

        // 2. detailed constructor
        Dog d2 = new Dog("Canine", "Home", 15, false,
                         "Black", 65, "Labrador", true, 10, "Swimming");
        d2.eat();
        d2.move();
        d2.sleep();
        d2.showLoyalty();

        System.out.println();

        // 3. copy constructor
        Dog d3 = new Dog(d2);
        d3.bark();
        d3.fetch();

        // instanceof checks
        System.out.println(d3 instanceof Dog);
        System.out.println(d3 instanceof Mammal);
        System.out.println(d3 instanceof Animal);
    }
}