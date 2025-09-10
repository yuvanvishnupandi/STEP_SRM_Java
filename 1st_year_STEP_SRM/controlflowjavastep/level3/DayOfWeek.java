import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter day: ");
        int d = sc.nextInt();
        
        System.out.print("Enter month: ");
        int m = sc.nextInt();
        
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        
        // Close the scanner
        sc.close();
        
        // Calculate day of the week
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int dayOfWeek = (d + x + (31 * m0) / 12) % 7;
        
        // Output the result
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("Day of the Week: " + days[dayOfWeek]);
    }
}