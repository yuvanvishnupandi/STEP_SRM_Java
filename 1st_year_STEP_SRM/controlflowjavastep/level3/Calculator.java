import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter first number: ");
        double first = sc.nextDouble();
        
        System.out.print("Enter second number: ");
        double second = sc.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        char op = sc.next().charAt(0);
        
        // Close the scanner
        sc.close();
        
        // Perform the calculation based on the operator
        switch (op) {
            case '+': 
                System.out.println("Result: " + (first + second)); 
                break;
            case '-': 
                System.out.println("Result: " + (first - second)); 
                break;
            case '*': 
                System.out.println("Result: " + (first * second)); 
                break;
            case '/': 
                if (second != 0) {
                    System.out.println("Result: " + (first / second));
                } else {
                    System.out.println("Undefined (division by zero)");
                }
                break;
            default: 
                System.out.println("Invalid Operator");
        }
    }
}