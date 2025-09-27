// 🧪 HW PROBLEM 4: Food Preparation Template
// Topic: Template Method Pattern

abstract class Food {
    // Template method
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    void wash() { System.out.println("Washing vegetables and dough..."); }
    void cook() { System.out.println("Baking pizza in oven..."); }
    void serve() { System.out.println("Serving hot pizza!"); }
}

class Soup extends Food {
    void wash() { System.out.println("Washing vegetables for soup..."); }
    void cook() { System.out.println("Boiling ingredients..."); }
    void serve() { System.out.println("Serving soup in bowl!"); }
}

public class HW4 {
    public static void main(String[] args) {
        Food pizza = new Pizza();
        Food soup = new Soup();

        System.out.println("Preparing Pizza:");
        pizza.prepare();

        System.out.println("\nPreparing Soup:");
        soup.prepare();
    }
}
