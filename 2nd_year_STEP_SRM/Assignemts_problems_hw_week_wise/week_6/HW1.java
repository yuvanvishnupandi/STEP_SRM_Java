// 🧪 HW PROBLEM 1: Light and LED Multiple Constructors
// Topic: Constructor Chaining with this() and super()

class Light {
    String type;

    Light() {
        this("Default Light");
        System.out.println("Light default constructor");
    }

    Light(String type) {
        this.type = type;
        System.out.println("Light constructor with type: " + type);
    }
}

class LED extends Light {
    int power;

    LED() {
        this("LED Light", 5);
        System.out.println("LED default constructor");
    }

    LED(String type, int power) {
        super(type);
        this.power = power;
        System.out.println("LED constructor with type: " + type + ", power: " + power + "W");
    }
}

public class HW1 {
    public static void main(String[] args) {
        System.out.println("Creating Light:");
        Light l1 = new Light();

        System.out.println("\nCreating LED:");
        LED led1 = new LED();
    }
}
