import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name (first and last): ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Enter a sentence about your programming experience: ");
        String experience = scanner.nextLine();

        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        int charCount = experience.replace(" ", "").length();
        String languageUpper = language.toUpperCase();

        System.out.println("\nFormatted Summary:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Programming Language: " + languageUpper);
        System.out.println("Experience Sentence: " + experience);
        System.out.println("Character count in experience (excluding spaces): " + charCount);

        scanner.close();
    }
}
