class SplitCompare {
    public static String[] splitWords(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0]; // Return an empty array for null or empty input
        }
        return text.split(" "); // Use Java's built-in split method
    }

    public static boolean compare(String[] a, String[] b) {
        if (a == null || b == null) {
            return false; // Return false if either array is null
        }
        if (a.length != b.length) {
            return false; // Arrays must have the same length
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false; // Return false if any element doesn't match
            }
        }
        return true; // Arrays are equal
    }

    public static void main(String[] args) {
        // Example usage
        String text1 = "hello world this is Java";
        String text2 = "hello world this is Java";

        String[] words1 = splitWords(text1);
        String[] words2 = splitWords(text2);

        System.out.println("Words in text1: " + String.join(", ", words1));
        System.out.println("Words in text2: " + String.join(", ", words2));
        System.out.println("Are the arrays equal? " + compare(words1, words2));
    }
}