import java.util.Arrays;
import java.util.Scanner;
class OddEvenArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();
        if (number <= 0) {
            System.out.println("Error: Not a natural number.");
            System.exit(0);
        }
        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0, oddIndex = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex++] = i;
            } else {
                oddNumbers[oddIndex++] = i;
            }
        }
        System.out.println("Odd Numbers: " + Arrays.toString(Arrays.copyOf(oddNumbers, oddIndex)));
        System.out.println("Even Numbers: " + Arrays.toString(Arrays.copyOf(evenNumbers, evenIndex)));
        input.close();
    }
}

