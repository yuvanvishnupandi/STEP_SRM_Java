import java.util.Scanner;

public class NumberChecker1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int digitCount = getDigitCount(number);
        int[] digits = getDigitsArray(number, digitCount);

        int sum = getSumOfDigits(digits);
        int sumOfSquares = getSumOfSquares(digits);
        boolean isHarshad = isHarshadNumber(number, sum);
        int[][] frequencyArray = getDigitFrequency(digits);

        System.out.println("Digit Count: " + digitCount);
        System.out.print("Digits Array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }

        System.out.println("\nSum of Digits: " + sum);
        System.out.println("Sum of Squares of Digits: " + sumOfSquares);
        System.out.println("Harshad Number: " + (isHarshad ? "Yes" : "No"));

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i][1] > 0) {
                System.out.println("Digit " + frequencyArray[i][0] + " => " + frequencyArray[i][1] + " times");
            }
        }
    }

    public static int getDigitCount(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number, int count) {
        int[] digits = new int[count];
        int index = count - 1;
        number = Math.abs(number);
        while (number > 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int getSumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int getSumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int sumOfDigits) {
        return sumOfDigits != 0 && number % sumOfDigits == 0;
    }

    public static int[][] getDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }
}
