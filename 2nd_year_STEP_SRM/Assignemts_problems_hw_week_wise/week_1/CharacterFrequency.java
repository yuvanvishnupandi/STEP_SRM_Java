//Find the Frequency of Characters in a String
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = findCharacterFrequency(input);
        
        for (String[] entry : result) {
            System.out.println(entry[0] + ": " + entry[1]);
        }
    }

    public static String[][] findCharacterFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        String[][] result = new String[text.length()][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = String.valueOf((char) i);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        String[][] finalResult = new String[index][2];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    
    }
}
