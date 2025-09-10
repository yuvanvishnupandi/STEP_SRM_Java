import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = scanner.nextLong();
        scanner.close();
        
        int[] freq = new int[10]; // Array to store frequency of digits (0-9)
        
        // Extract digits from the number and update frequency
        long temp = num;
        while (temp > 0) {
            int digit = (int) (temp % 10);
            freq[digit]++;
            temp /= 10;
        }
        
        // Display the frequency of each digit
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " appears " + freq[i] + " times.");
            }
        }
    }
}
