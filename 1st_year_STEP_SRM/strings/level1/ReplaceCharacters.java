
import java.util.Scanner;

public class ReplaceCharacters{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter character to replace: ");
        char oldChar = scanner.next().charAt(0);
        System.out.print("Enter new character: ");
        char newChar = scanner.next().charAt(0);

        String replaced = input.replace(oldChar, newChar);
        System.out.println("Modified string: " + replaced);
    }
}

