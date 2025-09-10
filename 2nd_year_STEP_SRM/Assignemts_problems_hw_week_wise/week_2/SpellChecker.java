//Problem 1: Simple Spell Checker
import java.util.Scanner;

public class SpellChecker {

    public static String[] splitIntoWords(String text) {
        int start = 0;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) count++;
        }
        String[] words = new String[count + 1];
        int wordIndex = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || Character.isWhitespace(text.charAt(i))) {
                if (start != i) {
                    words[wordIndex++] = text.substring(start, i);
                }
                start = i + 1;
            }
        }
        return words;
    }

    public static int calculateDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == len2) {
            int dist = 0;
            for (int i = 0; i < len1; i++) {
                if (word1.charAt(i) != word2.charAt(i)) dist++;
            }
            return dist;
        }
        return Math.abs(len1 - len2);
    }

    public static String findClosestWord(String word, String[] dictionary) {
        int minDistance = Integer.MAX_VALUE;
        String suggestion = "";
        for (String dictWord : dictionary) {
            int distance = calculateDistance(word, dictWord);
            if (distance < minDistance && distance <= 2) {
                minDistance = distance;
                suggestion = dictWord;
            }
        }
        return suggestion;
    }

    public static void displaySpellCheckResults(String sentence, String[] dictionary) {
        String[] words = splitIntoWords(sentence);
        System.out.println("Original Word | Suggested Correction | Distance Score | Status");
        for (String word : words) {
            String suggestion = findClosestWord(word, dictionary);
            int distance = calculateDistance(word, suggestion);
            String status = word.equals(suggestion) ? "Correct" : "Misspelled";
            System.out.printf("%-15s | %-19s | %-13d | %-10s\n", word, suggestion, distance, status);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence:");
        String sentence = sc.nextLine();
        String[] dictionary = {"the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog"};
        displaySpellCheckResults(sentence, dictionary);
        sc.close();
    }
}
