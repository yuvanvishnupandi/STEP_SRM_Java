 //Split Text into Words Without Using split() and Compare with Built-in
import java.util.Scanner;
import java.util.Arrays;

public class SplitWithoutSplitMethod {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitWords(String str) {
        int length = findLength(str);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount - 1; i++) {
            words[i] = str.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }
        words[wordCount - 1] = str.substring(start, length);
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] splitByMethod = splitWords(input);
        String[] splitBuiltIn = input.split(" ");

        System.out.println("Split by custom method: " + Arrays.toString(splitByMethod));
        System.out.println("Split by built-in split(): " + Arrays.toString(splitBuiltIn));

        boolean isSame = compareArrays(splitByMethod, splitBuiltIn);
        System.out.println("Both arrays are equal? " + isSame);

        sc.close();
    }
}
