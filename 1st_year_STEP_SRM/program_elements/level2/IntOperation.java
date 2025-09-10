import java.util.Scanner;

class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number (a): ");
        int a = input.nextInt();
        System.out.print("Enter second number (b): ");
        int b = input.nextInt();
        System.out.print("Enter third number (c): ");
        int c = input.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println("The results of Int Operations are:");
        System.out.println(result1 + ", " + result2 + ", " + result3 + ", " + result4);

        input.close();
    }
}
