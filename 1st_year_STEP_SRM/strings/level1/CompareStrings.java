import java.util.Scanner;

public class CompareStrings {
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine(); // Changed to nextLine() to allow spaces in input
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine(); // Changed to nextLine() to allow spaces in input

        boolean resultCharAt = compareUsingCharAt(s1, s2);
        boolean resultEquals = s1.equals(s2);

        System.out.println("Comparison using charAt(): " + resultCharAt);
        System.out.println("Comparison using equals(): " + resultEquals);

        scanner.close(); // Close the scanner to release resources
    }
}