import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];            // in kg
            double heightInCm = data[i][1];        // in cm
            double heightInMeters = heightInCm / 100.0;
            double bmi = weight / (heightInMeters * heightInMeters);
            data[i][2] = bmi; // Store BMI in the third column
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; // [weight, height(cm), BMI]

        // Step 1: Get input
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) of person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        // Step 2: Calculate BMI
        calculateBMI(data);

        // Step 3: Get BMI status
        String[] status = getBMIStatus(data);

        // Step 4: Display result
        System.out.println("\n--- BMI Results ---");
        System.out.println("Person\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n",
                (i + 1), data[i][0], data[i][1], data[i][2], status[i]);
        }
    }
}
