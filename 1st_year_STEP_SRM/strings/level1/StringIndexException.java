import java.util.Scanner;

public class StringIndexException{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        try {
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            char ch = input.charAt(index);
            System.out.println("Character at index " + index + ": " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bounds!");
            scanner.close();
        }
    }
}
