import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        // Check if the number is prime
        boolean isPrime = num > 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        // Output the result
        System.out.println(isPrime ? num + " is a Prime Number" : num + " is Not a Prime Number");
    }
}