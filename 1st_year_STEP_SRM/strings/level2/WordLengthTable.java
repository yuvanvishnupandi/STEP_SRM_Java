class WordLengthTable {
    public static String[][] getWordLengthTable(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(StringLength.findLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        String[] words = {"hello", "world", "Java", "programming"};
        String[][] table = getWordLengthTable(words);

        System.out.println("Word Length Table:");
        for (String[] row : table) {
            System.out.println(row[0] + " -> " + row[1]);
        }
    }
}