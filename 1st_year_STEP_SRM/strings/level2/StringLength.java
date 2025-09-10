import java.util.*;

class StringLength{
    public static int findLength(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.length();
    }

    public static void main(String[] args) {
        // Example usage
        String testString = "Hello, World!";
        System.out.println("Length of the string: " + findLength(testString));
    }
}