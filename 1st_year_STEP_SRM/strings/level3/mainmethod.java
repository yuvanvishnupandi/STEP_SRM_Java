import java.util.Arrays;
import java.util.Scanner;

public class mainmethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- BMI Calculation ---");
        double[][] data = {{60, 170}, {72, 165}};
        displayBMI(calculateBMI(data));

        System.out.println("\n--- Unique Characters ---");
        System.out.println(Arrays.toString(findUniqueChars("levelup")));

        System.out.println("\n--- First Non-Repeating Character ---");
        System.out.println(firstNonRepeating("swiss"));

        System.out.println("\n--- Character Frequency ---");
        String[][] freq = charFrequency("banana");
        for (String[] row : freq) System.out.println(Arrays.toString(row));

        System.out.println("\n--- Palindrome Checks ---");
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindromeRecursive("madam", 0, 4));
        System.out.println(isPalindromeUsingArray("madam"));

        System.out.println("\n--- Anagram Check ---");
        System.out.println(areAnagrams("listen", "silent"));

        System.out.println("\n--- Calendar Display ---");
        displayCalendar(4, 2025);

        System.out.println("\n--- Deck of Cards ---");
        String[] deck = initDeck();
        shuffleDeck(deck);
        String[][] players = distributeCards(deck, 4, 5);
        printPlayersCards(players);

        sc.close();
    }

    // Example implementations of the missing methods
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            String status = (bmi < 18.5) ? "Underweight" : (bmi < 24.9) ? "Normal" : (bmi < 29.9) ? "Overweight" : "Obese";
            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    public static void displayBMI(String[][] bmiData) {
        System.out.printf("%-10s%-10s%-10s%-15s%n", "Height", "Weight", "BMI", "Status");
        for (String[] row : bmiData) {
            System.out.printf("%-10s%-10s%-10s%-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static char[] findUniqueChars(String text) {
        return text.chars().distinct().mapToObj(c -> (char) c).toArray(Character[]::new);
    }

    public static char firstNonRepeating(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) freq[c]++;
        for (char c : text.toCharArray()) if (freq[c] == 1) return c;
        return '\0';
    }

    public static String[][] charFrequency(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) freq[c]++;
        return Arrays.stream(text.chars().distinct().toArray())
                .mapToObj(c -> new String[]{String.valueOf((char) c), String.valueOf(freq[c])})
                .toArray(String[][]::new);
    }

    public static boolean isPalindrome(String text) {
        return new StringBuilder(text).reverse().toString().equals(text);
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        return text.charAt(start) == text.charAt(end) && isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) reversed[i] = original[original.length - 1 - i];
        return Arrays.equals(original, reversed);
    }

    public static boolean areAnagrams(String text1, String text2) {
        if (text1.length() != text2.length()) return false;
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("\n\t" + new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = (1 + (year - (14 - month) / 12) + (year - (14 - month) / 12) / 4 - (year - (14 - month) / 12) / 100 + (year - (14 - month) / 12) / 400 + (31 * (month + 12 * ((14 - month) / 12) - 2) / 12)) % 7;
        int daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[month - 1] + (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? 1 : 0);
        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%3d ", i);
            if ((i + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static String[] initDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) for (String rank : ranks) deck[index++] = rank + " of " + suit;
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCard = i + (int) (Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) return null;
        String[][] result = new String[players][cardsPerPlayer];
        int index = 0;
        for (int i = 0; i < players; i++) for (int j = 0; j < cardsPerPlayer; j++) result[i][j] = deck[index++];
        return result;
    }

    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + Arrays.toString(players[i]));
        }
    }
}