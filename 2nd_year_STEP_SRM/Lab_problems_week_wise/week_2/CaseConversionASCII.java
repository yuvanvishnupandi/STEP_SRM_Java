//Problem 2: Convert text between uppercase, lowercase, and title case using ASCII values without built-in methods
import java.util.Scanner;

public class CaseConversionASCII {

    public static char toUpperCaseChar(char ch) {
        if (ch >= 'a' && ch <= 'z') return (char) (ch - 32);
        return ch;
    }

    public static char toLowerCaseChar(char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char) (ch + 32);
        return ch;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(toUpperCaseChar(str.charAt(i)));
        }
        return sb.toString();
    }

    public static String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(toLowerCaseChar(str.charAt(i)));
        }
        return sb.toString();
    }

    public static String toTitleCase(String str) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                sb.append(ch);
                newWord = true;
            } else if (newWord) {
                sb.append(toUpperCaseChar(ch));
                newWord = false;
            } else {
                sb.append(toLowerCaseChar(ch));
            }
        }
        return sb.toString();
    }

    public static boolean compareUpper(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static boolean compareLower(String manual, String builtin) {
        return manual.equals(builtin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();

        String manualUpper = toUpperCase(input);
        String manualLower = toLowerCase(input);
        String manualTitle = toTitleCase(input);

        String builtinUpper = input.toUpperCase();
        String builtinLower = input.toLowerCase();

        System.out.printf("%-20s %-20s %-20s%n", "Conversion", "Manual", "Built-in");
        System.out.printf("%-20s %-20s %-20s%n", "Uppercase", manualUpper, builtinUpper);
        System.out.printf("%-20s %-20s %-20s%n", "Lowercase", manualLower, builtinLower);
        System.out.printf("%-20s %-20s%n", "Title Case", manualTitle);

        System.out.println("\nUppercase matches? " + compareUpper(manualUpper, builtinUpper));
        System.out.println("Lowercase matches? " + compareLower(manualLower, builtinLower));

        sc.close();
    }
}
