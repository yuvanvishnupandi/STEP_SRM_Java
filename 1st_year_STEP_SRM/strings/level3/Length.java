import java.util.Arrays;

public class Length{

    public static int findLength(String text) {
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (Exception e) {
            return len;
        }
    }

    public static char[] findUniqueChars(String text) {
        int n = findLength(text);
        char[] unique = new char[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) unique[count++] = ch;
        }
        return Arrays.copyOf(unique, count);
    }

    public static void main(String[] args) {
        String text = "programming";
        System.out.println("Length of the string: " + findLength(text));
        System.out.println("Unique characters: " + Arrays.toString(findUniqueChars(text)));
    }
}