// 🧪 LAB PROBLEM 1: Fruit and Apple Classes
// Topic: Basic Single Inheritance

class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public void displayInfo() {
        System.out.println("Color: " + color + ", Taste: " + taste);
    }
}

class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public void showApple() {
        displayInfo();
        System.out.println("Variety: " + variety);
    }
}

