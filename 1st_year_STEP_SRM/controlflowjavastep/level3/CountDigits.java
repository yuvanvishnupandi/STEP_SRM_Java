import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        int count = 0;
        int original = num;
        
        // Count the number of digits
        while (num > 0) {
            count++;
            num /= 10;
        }
        
        // Output the result
        System.out.println("Number of digits in " + original + ": " + count);
    }
}