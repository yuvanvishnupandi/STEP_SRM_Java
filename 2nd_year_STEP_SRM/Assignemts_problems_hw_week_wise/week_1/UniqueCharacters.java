//Find Unique Characters in a String using charAt()
import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int length = getLength(input);
        char[] uniqueChars = findUniqueCharacters(input, length);
        
        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }

    public static int getLength(String text) {
        int length = 0;
        while (true) {
            try {
                text.charAt(length);
                length++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return length;
    }

    public static char[] findUniqueCharacters(String text, int length) {
        char[] result = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                result[index++] = currentChar;
            }
        }
        char[] uniqueChars = new char[index];
        System.arraycopy(result, 0, uniqueChars, 0, index);
        return uniqueChars;
    }
}
