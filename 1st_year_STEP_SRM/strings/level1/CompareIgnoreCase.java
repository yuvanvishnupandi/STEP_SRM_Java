import java.util.Scanner;

public class CompareIgnoreCase{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        boolean result = s1.equalsIgnoreCase(s2);
        System.out.println("Are strings equal ignoring case? " + result);
    }
}
