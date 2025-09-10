//Problem 4: Text-Based Calculator
import java.util.Scanner;

public class Calculator {

    public static boolean validateExpression(String expression) {
        for (char ch : expression.toCharArray()) {
            if (!Character.isDigit(ch) && !"+-*/()".contains(String.valueOf(ch)) && !Character.isWhitespace(ch)) {
                return false;
            }
        }
        return true;
    }

    public static int evaluateExpression(String expression) {
        String[] tokens = expression.split(" ");
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            int num = Integer.parseInt(tokens[i + 1]);
            switch (tokens[i]) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    result /= num;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression:");
        String expression = sc.nextLine();

        if (validateExpression(expression)) {
            int result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression.");
        }

        sc.close();
    }
}
