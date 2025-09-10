import java.util.Scanner;
import java.util.Random;

public class FootballTeamHeightAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the number of players in the football team: ");
        int numberOfPlayers = scanner.nextInt();

        int[] heights = new int[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            heights[i] = random.nextInt(101) + 150;
        }

        int sum = calculateSum(heights);
        double mean = calculateMean(sum, numberOfPlayers);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        System.out.println("\nHeights of Players:");
        for (int height : heights) {
            System.out.print(height + " ");
        }

        System.out.println("\n\nShortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
        System.out.println("Mean Height: " + String.format("%.2f", mean) + " cm");
    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static double calculateMean(int sum, int count) {
        return (double) sum / count;
    }

    public static int findShortest(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int findTallest(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
