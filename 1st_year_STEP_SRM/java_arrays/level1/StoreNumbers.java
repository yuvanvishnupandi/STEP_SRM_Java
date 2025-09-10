import java.util.Scanner;
class StoreNumbers {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       double[] numbers = new double[10];
       double sum = 0.0;
       int index = 0;
       while (index < 10) {
          System.out.print("Enter a number: ");
          double num = input.nextDouble();
          if (num <= 0) break;
          numbers[index++] = num;
       }
       for (int i = 0; i < index; i++) {
          sum += numbers[i];
       }
       System.out.println("Total sum: " + sum);
       input.close();
    }
 }
 