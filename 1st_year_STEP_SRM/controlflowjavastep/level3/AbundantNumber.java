import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        int sum = 0;
        
        // Calculate the sum of proper divisors
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i;
        }
        
        // Check if the number is an Abundant number
        System.out.println(sum > num ? "Abundant Number" : "Not an Abundant Number");
    }
}