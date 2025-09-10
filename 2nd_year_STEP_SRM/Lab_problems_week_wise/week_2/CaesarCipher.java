//Problem 4: Simple encryption and decryption system (Caesar Cipher)
import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char shifted = (char) ((ch - 'A' + shift) % 26);
                if (shifted < 0) shifted += 26;
                encrypted.append((char) ('A' + shifted));
            } else if (ch >= 'a' && ch <= 'z') {
                char shifted = (char) ((ch - 'a' + shift) % 26);
                if (shifted < 0) shifted += 26;
                encrypted.append((char) ('a' + shifted));
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    public static void displayAsciiValues(String label, String text) {
        System.out.print(label + ": ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i) + "(" + (int)text.charAt(i) + ") ");
        }
        System.out.println();
    }

    public static boolean validateDecryption(String original, String decrypted) {
        return original.equals(decrypted);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encrypt:");
        String text = sc.nextLine();

        System.out.println("Enter shift value:");
        int shift = sc.nextInt();

        displayAsciiValues("Original text ASCII values", text);

        String encrypted = encrypt(text, shift);
        displayAsciiValues("Encrypted text ASCII values", encrypted);

        String decrypted = decrypt(encrypted, shift);
        displayAsciiValues("Decrypted text ASCII values", decrypted);

        System.out.println("Decryption successful? " + validateDecryption(text, decrypted));

        sc.close();
    }
}
