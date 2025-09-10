//Practice Problem 2: String Manipulation Methods
import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence with mixed formatting: ");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        String replacedSpaces = trimmed.replace(" ", "_");
        String removedDigits = replacedSpaces.replaceAll("\\d", "");
        String[] wordsArray = removedDigits.split(" ");
        String joinedWords = String.join(" | ", wordsArray);

        System.out.println("Trimmed: " + trimmed);
        System.out.println("Spaces replaced with underscores: " + replacedSpaces);
        System.out.println("Digits removed: " + removedDigits);
        System.out.println("Words array: ");
        for (String word : wordsArray) {
            System.out.println(word);
        }
        System.out.println("Rejoined words: " + joinedWords);
        
        System.out.println("Text after punctuation removal: " + removePunctuation(input));
        System.out.println("Text with capitalized words: " + capitalizeWords(input));
        System.out.println("Reversed word order: " + reverseWordOrder(input));
        countWordFrequency(input);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void countWordFrequency(String text) {
        String[] words = text.split(" ");
        java.util.Map<String, Integer> wordCount = new java.util.HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
