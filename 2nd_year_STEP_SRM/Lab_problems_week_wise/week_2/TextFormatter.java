//Problem 6: Text formatter that justifies text to a specified width using StringBuilder
import java.util.Scanner;
import java.util.ArrayList;

public class TextFormatter {

    public static String[] splitIntoWords(String text) {
        ArrayList<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i <= text.length(); i++) {
            if (i == text.length() || text.charAt(i) == ' ') {
                if (start != i) {
                    words.add(text.substring(start, i));
                }
                start = i + 1;
            }
        }
        return words.toArray(new String[0]);
    }

      public static String justifyLine(String[] words, int maxWidth, boolean isLastLine) {
        if (words.length == 0) return "";
        if (words.length == 1 || isLastLine) {
            StringBuilder line = new StringBuilder(words[0]);
            for (int i = 1; i < words.length; i++) {
                line.append(" ").append(words[i]);
            }
            int remaining = maxWidth - line.length();
            for (int i = 0; i < remaining; i++) {
                line.append(" ");
            }
            return line.toString();
        }

        int totalChars = 0;
        for (String w : words) totalChars += w.length();
        int totalSpaces = maxWidth - totalChars;
        int spaceSlots = words.length - 1;
        int evenSpaces = totalSpaces / spaceSlots;
        int extraSpaces = totalSpaces % spaceSlots;

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            line.append(words[i]);
            if (i < words.length - 1) {
                for (int s = 0; s < evenSpaces; s++) line.append(" ");
                if (extraSpaces > 0) {
                    line.append(" ");
                    extraSpaces--;
                }
            }
        }
        return line.toString();
    }

    public static ArrayList<String> justifyText(String text, int maxWidth) {
        String[] words = splitIntoWords(text);
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<String> currentLineWords = new ArrayList<>();
        int currentLen = 0;

        for (String w : words) {
            if (currentLen + w.length() + currentLineWords.size() > maxWidth) {
                lines.add(justifyLine(currentLineWords.toArray(new String[0]), maxWidth, false));
                currentLineWords.clear();
                currentLen = 0;
            }
            currentLineWords.add(w);
            currentLen += w.length();
        }
        if (!currentLineWords.isEmpty()) {
            lines.add(justifyLine(currentLineWords.toArray(new String[0]), maxWidth, true));
        }
        return lines;
    }
    public static String centerAlign(String line, int width) {
        int padding = width - line.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        StringBuilder sb = new StringBuilder();

    }
}