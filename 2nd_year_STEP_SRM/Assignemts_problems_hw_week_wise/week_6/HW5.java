// 🧪 HW PROBLEM 5: Math Operations Inheritance
// Topic: Inheritance with Method Overloading

class BasicMath {
    int calculate(int a, int b) {
        return a + b;
    }

    double calculate(double a, double b) {
        return a * b;
    }
}

class AdvancedMath extends BasicMath {
    double calculate(int a, int b, int c) {
        return a + b + c;
    }

    double calculate(double a, int b) {
        return Math.pow(a, b);
    }
}

public class HW5 {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();

        System.out.println("Sum (int): " + math.calculate(2, 3));
        System.out.println("Product (double): " + math.calculate(2.5, 3.5));
        System.out.println("Sum of three: " + math.calculate(1, 2, 3));
        System.out.println("Power: " + math.calculate(2.0, 3));
    }
}
