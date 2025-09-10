 //Split Text and Find Shortest and Longest Words
import java.util.Scanner;

public class ShortestLongestWords {

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
        int idx = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[idx++] = i;
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

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordsLen) {
        int shortestIdx = 0;
        int longestIdx = 0;
        int shortestLen = Integer.parseInt(wordsLen[0][1]);
        int longestLen = Integer.parseInt(wordsLen[0][1]);

        for (int i = 1; i < wordsLen.length; i++) {
            int currLen = Integer.parseInt(wordsLen[i][1]);
            if (currLen < shortestLen) {
                shortestLen = currLen;
                shortestIdx = i;
            }
            if (currLen > longestLen) {
                longestLen = currLen;
                longestIdx = i;
            }
        }
        return new int[] { shortestIdx, longestIdx };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordsLen = wordsWithLengths(words);
        int[] indices = findShortestLongest(wordsLen);

        System.out.println("Shortest word: " + wordsLen[indices[0]][0] + " with length " + wordsLen[indices[0]][1]);
        System.out.println("Longest word: " + wordsLen[indices[1]][0] + " with length " + wordsLen[indices[1]][1]);

        sc.close();
    }
}
