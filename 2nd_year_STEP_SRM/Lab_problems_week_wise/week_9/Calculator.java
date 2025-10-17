// Interface for the anonymous class
interface MathOperation {
    int operate(int a, int b);
}

public class Calculator {

    // 1. Static nested class
    static class Operation {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    // 2. Method with a local inner class
    public int performSubtraction(int a, int b) {
        // Local inner class
        class Subtractor {
            int subtract() {
                return a - b;
            }
        }
        Subtractor s = new Subtractor();
        return s.subtract();
    }
    
    // 3. Method using an anonymous inner class
    public int performMultiplication(int a, int b) {
        // Anonymous inner class implementing the interface
        MathOperation multiplier = new MathOperation() {
            @Override
            public int operate(int x, int y) {
                return x * y;
            }
        };
        return multiplier.operate(a, b);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int x = 10, y = 5;

        // Demonstrate static nested class
        int sum = Calculator.Operation.add(x, y);
        System.out.println("1. Static Nested Class (Addition): " + x + " + " + y + " = " + sum);

        // Demonstrate local inner class
        int difference = calc.performSubtraction(x, y);
        System.out.println("2. Local Inner Class (Subtraction): " + x + " - " + y + " = " + difference);
        
        // Demonstrate anonymous inner class
        int product = calc.performMultiplication(x, y);
        System.out.println("3. Anonymous Inner Class (Multiplication): " + x + " * " + y + " = " + product);
    }
}