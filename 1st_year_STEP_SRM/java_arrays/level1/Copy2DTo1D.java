import java.util.Arrays;
import java.util.Scanner;
class Copy2DTo1D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows: ");
        int rows = input.nextInt();
        System.out.print("Enter columns: ");
        int cols = input.nextInt();
        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        System.out.println("Enter elements of 2D array:");
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
                array[index++] = matrix[i][j];
            }
        }
        System.out.println("1D Array: " + Arrays.toString(array));
        input.close();
    }
}

