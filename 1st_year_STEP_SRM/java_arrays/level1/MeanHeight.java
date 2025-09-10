import java.util.Scanner;
class MeanHeight {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       double[] heights = new double[11];
       double sum = 0;
       for (int i = 0; i < 11; i++) {
          System.out.print("Enter height of player " + (i + 1) + ": ");
          heights[i] = input.nextDouble();
          sum += heights[i];
       }
       double mean = sum / 11;
       System.out.println("Mean height: " + mean);
       input.close();
    }
 }
 