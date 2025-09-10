class StringTrimmer {
    public static int[] getTrimIndices(String str) {
        int start = 0, end = StringLength.findLength(str) - 1;
        while (str.charAt(start) == ' ') start++;
        while (str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (StringLength.findLength(a) != StringLength.findLength(b)) return false;
        for (int i = 0; i < StringLength.findLength(a); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        String str = "   Hello World!   ";
        int[] indices = getTrimIndices(str);
        System.out.println("Trim indices: Start = " + indices[0] + ", End = " + indices[1]);

        String trimmed = customSubstring(str, indices[0], indices[1]);
        System.out.println("Trimmed string: \"" + trimmed + "\"");

        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println("Are strings equal? " + compareStrings(str1, str2));
    }
}