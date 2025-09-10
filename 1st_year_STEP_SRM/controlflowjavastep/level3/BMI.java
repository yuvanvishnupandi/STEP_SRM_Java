import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();
        
        System.out.print("Enter height in centimeters: ");
        double height = sc.nextDouble() / 100; // Convert height to meters
        
        // Calculate BMI
        double bmi = weight / (height * height);
        
        // Output the result
        System.out.println("BMI: " + bmi);
        
        // Close the scanner
        sc.close();
    }
}