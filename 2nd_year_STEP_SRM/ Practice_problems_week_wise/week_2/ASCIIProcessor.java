//Practice Problem 3: ASCII Codes and Character Conversion
import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            System.out.println("Character: " + ch + " ASCII: " + (int) ch);
            System.out.println(classifyCharacter(ch));
            if (Character.isLetter(ch)) {
                System.out.println("Uppercase ASCII: " + (int) Character.toUpperCase(ch));
                System.out.println("Lowercase ASCII: " + (int) Character.toLowerCase(ch));
            }
        }

        System.out.println("ASCII Art:");
        displayASCIITable(65, 90);

        System.out.println("Caesar Cipher: " + caesarCipher(input, 3));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) {
            return Character.toLowerCase(ch);
        } else if (Character.isLowerCase(ch)) {
            return Character.toUpperCase(ch);
        }
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println((char) i + ": " + i);
        }
    }
}
