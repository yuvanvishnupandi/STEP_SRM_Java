import java.util.Arrays;

public class palindromecheck {

    public static boolean isPalindrome(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) if (text.charAt(start++) != text.charAt(end--)) return false;
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) reversed[i] = text.charAt(original.length - 1 - i);
        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {
        String text = "madam";
        System.out.println("Is palindrome (iterative): " + isPalindrome(text));
        System.out.println("Is palindrome (recursive): " + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Is palindrome (using array): " + isPalindromeUsingArray(text));
    }
}