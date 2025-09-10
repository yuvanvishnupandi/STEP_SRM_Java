import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = getFactors(number);
        int greatestFactor = getGreatestFactor(factors);
        int sumOfFactors = getSumOfFactors(factors);
        int productOfFactors = getProductOfFactors(factors);
        double cubeProduct = getCubeProductOfFactors(factors);

        boolean isPerfect = isPerfectNumber(number);
        boolean isAbundant = isAbundantNumber(number);
        boolean isDeficient = isDeficientNumber(number);
        boolean isStrong = isStrongNumber(number);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");

        System.out.println("\nGreatest Factor: " + greatestFactor);
        System.out.println("Sum of Factors: " + sumOfFactors);
        System.out.println("Product of Factors: " + productOfFactors);
        System.out.println("Product of Cubes of Factors: " + (long) cubeProduct);

        System.out.println("Perfect Number: " + (isPerfect ? "Yes" : "No"));
        System.out.println("Abundant Number: " + (isAbundant ? "Yes" : "No"));
        System.out.println("Deficient Number: " + (isDeficient ? "Yes" : "No"));
        System.out.println("Strong Number: " + (isStrong ? "Yes" : "No"));
    }

    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int getGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > max) max = factors[i];
        }
        return max;
    }

    public static int getSumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int getProductOfFactors(int[] factors) {
        int product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    public static double getCubeProductOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) sum += i;
        }
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int original = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == original;
    }

    public static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) fact *= i;
        return fact;
    }
}
