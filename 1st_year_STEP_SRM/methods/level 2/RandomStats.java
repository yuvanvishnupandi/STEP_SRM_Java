import java.util.Arrays;

public class RandomStats {

    // a. Method to generate an array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int)(Math.random() * 9000) + 1000; // 1000 to 9999
        }
        return numbers;
    }

    // b. Method to find average, min and max value of an array
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);

        System.out.println("Generated 4-digit random numbers: " + Arrays.toString(randomNumbers));

        double[] results = findAverageMinMax(randomNumbers);

        System.out.printf("Average: %.2f\n", results[0]);
        System.out.printf("Minimum: %.0f\n", results[1]);
        System.out.printf("Maximum: %.0f\n", results[2]);
    }
}
