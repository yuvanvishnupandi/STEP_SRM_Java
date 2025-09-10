import java.util.Scanner;

class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number (x): ");
        double x = input.nextDouble();
        System.out.print("Enter second number (y): ");
        double y = input.nextDouble();
        System.out.print("Enter third number (z): ");
        double z = input.nextDouble();

        double result1 = x + y * z;
        double result2 = x * y + z;
        double result3 = z + x / y;
        double result4 = x % y + z;

        System.out.println("The results of Double Operations are:");
        System.out.println(result1 + ", " + result2 + ", " + result3 + ", " + result4);

        input.close();
    }
}