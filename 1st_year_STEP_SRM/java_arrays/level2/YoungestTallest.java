import java.util.Scanner;

public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Do not close Scanner here
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height for " + names[i] + ":");
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }
        
        int minAgeIndex = 0, maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIndex]) minAgeIndex = i;
            if (height[i] > height[maxHeightIndex]) maxHeightIndex = i;
        }
        
        System.out.println("Youngest: " + names[minAgeIndex]);
        System.out.println("Tallest: " + names[maxHeightIndex]);
        
        sc.close(); // Close Scanner after all input operations are complete
    }
}