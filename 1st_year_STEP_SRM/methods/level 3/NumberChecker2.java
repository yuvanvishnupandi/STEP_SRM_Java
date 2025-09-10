import java.util.Scanner;
import java.util.Arrays;

public class NumberChecker2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int digitCount = getDigitCount(number);
        int[] originalDigits = getDigitsArray(number, digitCount);
        int[] reversedDigits = reverseDigitsArray(originalDigits);

        boolean isPalindrome = areArraysEqual(originalDigits, reversedDigits);
        boolean isDuck = isDuckNumber(originalDigits);

        System.out.println("Digit Count: " + digitCount);

        System.out.print("Original Digits: ");
        for (int digit : originalDigits) {
            System.out.print(digit + " ");
        }

        System.out.print("\nReversed Digits: ");
        for (int digit : reversedDigits) {
            System.out.print(digit + " ");
        }

        System.out.println("\nPalindrome Number: " + (isPalindrome ? "Yes" : "No"));
        System.out.println("Duck Number: " + (isDuck ? "Yes" : "No"));
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

    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }
}
