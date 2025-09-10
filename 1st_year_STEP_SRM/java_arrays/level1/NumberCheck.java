import java.util.Scanner;

class NumberCheck {
    public static void main(String[] args) {
        // Use try-with-resources to ensure Scanner is closed properly
        try (Scanner input = new Scanner(System.in)) {
            int[] numbers = new int[5];
            for (int i = 0; i < numbers.length; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                numbers[i] = input.nextInt();
            }
            for (int num : numbers) {
                if (num > 0) {
                    if (num % 2 == 0) {
                        System.out.println(num + " is positive and even.");
                    } else {
                        System.out.println(num + " is positive and odd.");
                    }
                } else if (num < 0) {
                    System.out.println(num + " is negative.");
                } else {
                    System.out.println("Number is zero.");
                }
            }
            if (numbers[0] > numbers[4]) {
                System.out.println("First number is greater than last.");
            } else if (numbers[0] < numbers[4]) {
                System.out.println("First number is less than last.");
            } else {
                System.out.println("First and last numbers are equal.");
            }
        }
    }
}