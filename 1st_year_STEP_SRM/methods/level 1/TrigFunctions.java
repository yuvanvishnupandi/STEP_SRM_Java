import java.util.Scanner;

public class TrigFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double angle = sc.nextDouble();
        double[] trigValues = calculateTrigonometricFunctions(angle);
        System.out.println("Sin: " + trigValues[0]);
        System.out.println("Cos: " + trigValues[1]);
        System.out.println("Tan: " + trigValues[2]);
    }
}
