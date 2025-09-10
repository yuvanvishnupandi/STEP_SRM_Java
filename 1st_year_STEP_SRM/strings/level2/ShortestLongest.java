class ShortestLongest {
    public static int[] findShortestAndLongest(String[][] table) {
        if (table == null || table.length == 0) {
            throw new IllegalArgumentException("Input table cannot be null or empty");
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIndex = 0, maxIndex = 0;

        for (int i = 0; i < table.length; i++) {
            int len = Integer.parseInt(table[i][1]);
            if (len < min) {
                min = len;
                minIndex = i;
            }
            if (len > max) {
                max = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        // Example usage
        String[][] table = {
            {"hello", "5"},
            {"world", "5"},
            {"Java", "4"},
            {"programming", "11"}
        };

        int[] result = findShortestAndLongest(table);
        System.out.println("Shortest word index: " + result[0]);
        System.out.println("Longest word index: " + result[1]);
    }
}