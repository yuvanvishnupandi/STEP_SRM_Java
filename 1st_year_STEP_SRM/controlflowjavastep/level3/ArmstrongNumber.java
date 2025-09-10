import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        int original = num, sum = 0;
        
        // Calculate the sum of the cubes of the digits
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, 3);
            num /= 10;
        }
        
        // Output the result
        System.out.println(sum == original ? "Armstrong Number" : "Not an Armstrong Number");
    }
}