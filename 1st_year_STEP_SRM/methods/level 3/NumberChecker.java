import java.util.Scanner;

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int digitCount = getDigitCount(number);
        int[] digits = getDigitsArray(number, digitCount);

        boolean isDuck = isDuckNumber(digits);
        boolean isArmstrong = isArmstrongNumber(digits, number);
        int[] largestTwo = findLargestAndSecondLargest(digits);
        int[] smallestTwo = findSmallestAndSecondSmallest(digits);

        System.out.println("Digit Count: " + digitCount);
        System.out.print("Digits Array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println("\nDuck Number: " + (isDuck ? "Yes" : "No"));
        System.out.println("Armstrong Number: " + (isArmstrong ? "Yes" : "No"));
        System.out.println("Largest Digit: " + largestTwo[0]);
        System.out.println("Second Largest Digit: " + largestTwo[1]);
        System.out.println("Smallest Digit: " + smallestTwo[0]);
        System.out.println("Second Smallest Digit: " + smallestTwo[1]);
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

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits, int number) {
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest == Integer.MIN_VALUE ? -1 : secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest};
    }
}
