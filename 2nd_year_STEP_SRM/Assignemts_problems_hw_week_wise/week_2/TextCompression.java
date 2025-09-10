//Problem 3: Text Compression
import java.util.Scanner;

public class TextCompression {

    public static int[] countFrequency(String text) {
        int[] freq = new int[128];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        return freq;
    }

    public static StringBuilder compressText(String text, int[] freq) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            compressed.append(text.charAt(i));
            if (freq[text.charAt(i)] > 1) {
                compressed.append(freq[text.charAt(i)]);
            }
        }
        return compressed;
    }

    public static String decompressText(StringBuilder compressed) {
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            char current = compressed.charAt(i);
            decompressed.append(current);
        }
        return decompressed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        int[] freq = countFrequency(text);
        StringBuilder compressed = compressText(text, freq);
        String decompressed = decompressText(compressed);

        System.out.println("Original Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);

        sc.close();
    }
}
