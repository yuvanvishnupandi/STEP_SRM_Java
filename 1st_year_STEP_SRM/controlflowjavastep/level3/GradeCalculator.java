import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter Physics marks: ");
        int physics = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter Mathematics marks: ");
        int mathematics = sc.nextInt();
        
        // Close the scanner
        sc.close();

        // Validate input
        if (physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100 || mathematics < 0 || mathematics > 100) {
            System.out.println("Invalid input! Marks should be between 0 and 100.");
            return;
        }

        // Calculate average
        double average = (physics + chemistry + mathematics) / 3.0;
        System.out.println("Average: " + average + "%");

        // Determine grade
        if (average >= 90) {
            System.out.println("Grade: A");
        } else if (average >= 80) {
            System.out.println("Grade: B");
        } else if (average >= 70) {
            System.out.println("Grade: C");
        } else if (average >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}

