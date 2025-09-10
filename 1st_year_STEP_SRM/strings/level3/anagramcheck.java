import java.util.Arrays;

public class anagramcheck {

    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) return false;
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }
        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        String text1 = "listen";
        String text2 = "silent";
        if (areAnagrams(text1, text2)) {
            System.out.println(text1 + " and " + text2 + " are anagrams.");
        } else {
            System.out.println(text1 + " and " + text2 + " are not anagrams.");
        }
    }
}