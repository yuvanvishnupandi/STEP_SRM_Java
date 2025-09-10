//Practice Problem 1: Built-In String Methods - Basic Operations
public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";

        System.out.println("Original String Length: " + sampleText.length());
        System.out.println("Length after trimming: " + sampleText.trim().length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        System.out.println("Substring 'Programming': " + sampleText.substring(5, 16));
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("Contains 'Java': " + sampleText.contains("Java"));
        System.out.println("Starts with 'Java' (after trim): " + sampleText.trim().startsWith("Java"));
        System.out.println("Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());

        System.out.println("Vowel count: " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.println("Found '" + target + "' at index: " + i);
            }
        }
    }
}
