import java.util.Scanner;

public class problem4{
    public static String cleanInput(String input) {
        return input.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int charCount = text.replaceAll("\\s+", "").length();
        String longestWord = "";
        char mostCommonChar = '\0';
        int maxCount = 0;
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int count = (int) text.chars().filter(ch -> ch == c).count();
                if (count > maxCount) {
                    maxCount = count;
                    mostCommonChar = c;
                }
            }
        }

        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: " + mostCommonChar);
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        java.util.Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        
        System.out.print("Enter a paragraph of text: ");
        String text = scanner.nextLine();

        String cleanedText = cleanInput(text);
        System.out.println("\nCleaned Text: " + cleanedText);

        analyzeText(cleanedText);
        
        String[] sortedWords = getWordsSorted(cleanedText);
        System.out.println("\nSorted Words:");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        scanner.close();
    }
}
