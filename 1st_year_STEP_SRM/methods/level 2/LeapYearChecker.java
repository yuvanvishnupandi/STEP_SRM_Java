import java.util.Scanner;

public class LeapYearChecker {

    public static boolean isLeapYear(int year) {
        if (year < 1582) {
            return false;
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year < 1582) {
            System.out.println("Invalid input. Leap year check only works for year 1582 and later (Gregorian calendar).");
            return;
        }

        if (isLeapYear(year)) {
            System.out.println("Year " + year + " is a Leap Year.");
        } else {
            System.out.println("Year " + year + " is not a Leap Year.");
        }
    }
}
