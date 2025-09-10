//Problem 2: Password Strength Analyzer and Generator
import java.util.Random;
import java.util.Scanner;

public class PasswordStrengthAnalyzer {

    public static int analyzeStrength(String password) {
        int score = 0;
        int upper = 0, lower = 0, digits = 0, special = 0;
        for (char ch : password.toCharArray()) {
            if (ch >= 65 && ch <= 90) upper++;
            else if (ch >= 97 && ch <= 122) lower++;
            else if (ch >= 48 && ch <= 57) digits++;
            else special++;
        }
        if (password.length() > 8) score += (password.length() - 8) * 2;
        score += (upper > 0) ? 10 : 0;
        score += (lower > 0) ? 10 : 0;
        score += (digits > 0) ? 10 : 0;
        score += (special > 0) ? 10 : 0;

        if (password.contains("123") || password.contains("abc") || password.contains("qwerty")) score -= 10;
        return score;
    }

    public static String generateStrongPassword(int length) {
        Random rand = new Random();
        StringBuilder password = new StringBuilder(length);
        password.append((char) (rand.nextInt(26) + 65));  // Uppercase
        password.append((char) (rand.nextInt(26) + 97));  // Lowercase
        password.append((char) (rand.nextInt(10) + 48));  // Digit
        password.append((char) (rand.nextInt(15) + 33));  // Special character
        for (int i = 4; i < length; i++) {
            password.append((char) (rand.nextInt(94) + 33));  // Random printable characters
        }
        return password.toString();
    }

    public static void displayAnalysis(String password) {
        int score = analyzeStrength(password);
        String strength = score <= 20 ? "Weak" : (score <= 50 ? "Medium" : "Strong");
        System.out.printf("Password: %s | Strength: %s | Score: %d\n", password, strength, score);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password to analyze:");
        String password = sc.nextLine();
        displayAnalysis(password);

        System.out.println("Enter desired password length for generation:");
        int length = sc.nextInt();
        String strongPassword = generateStrongPassword(length);
        System.out.println("Generated strong password: " + strongPassword);

        sc.close();
    }
}
