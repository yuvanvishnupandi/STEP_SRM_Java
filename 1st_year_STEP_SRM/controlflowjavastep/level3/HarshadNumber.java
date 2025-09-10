import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        int sum = 0, temp = num;
        
        // Calculate the sum of the digits
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        
        // Check if the number is a Harshad number
        System.out.println(num % sum == 0 ? "Harshad Number" : "Not a Harshad Number");
    }
}