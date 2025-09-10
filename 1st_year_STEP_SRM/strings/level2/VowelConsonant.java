class VowelConsonant {
    public static String getType(char ch) {
        // Convert uppercase to lowercase
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
        // Check if the character is a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVC(String str) {
        int v = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            String type = getType(str.charAt(i));
            if (type.equals("Vowel")) v++;
            else if (type.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }

    public static String[][] charTypeTable(String str) {
        int len = str.length();
        String[][] result = new String[len][2];
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getType(ch);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        String str = "Hello World!";
        int[] vcCount = countVC(str);
        System.out.println("Vowels: " + vcCount[0] + ", Consonants: " + vcCount[1]);

        String[][] table = charTypeTable(str);
        System.out.println("Character Type Table:");
        for (String[] row : table) {
            System.out.println(row[0] + " -> " + row[1]);
        }
    }
}