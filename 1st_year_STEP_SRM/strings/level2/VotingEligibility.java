import java.util.Random;

public class VotingEligibility {
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90);
        }
        return ages;
    }

    public static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] ages = generateAges(10);
        String[][] eligibility = canVote(ages);

        System.out.println("Age -> Can Vote");
        for (String[] row : eligibility) {
            System.out.println(row[0] + " -> " + row[1]);
        }
    }
}