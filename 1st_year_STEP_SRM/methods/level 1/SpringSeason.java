import java.util.Scanner;

public class SpringSeason {
    public static boolean isSpring(int month, int day) {
        return (month == 3 && day >= 20) || (month == 6 && day <= 20) || (month > 3 && month < 6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.println(isSpring(month, day) ? "Its a Spring Season" : "Not a Spring Season");
    }
}
