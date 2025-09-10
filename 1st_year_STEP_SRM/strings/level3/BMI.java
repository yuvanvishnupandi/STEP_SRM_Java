import java.util.*;

public class BMI {

    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4]; // Dynamically size the array
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 24.9) status = "Normal";
            else if (bmi < 29.9) status = "Overweight";
            else status = "Obese";
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

    public static void main(String[] args) {
        // Sample data: {weight (kg), height (cm)}
        double[][] sampleData = {
            {70, 175},
            {50, 160},
            {90, 180},
            {110, 165}
        };

        // Calculate BMI
        String[][] bmiResults = calculateBMI(sampleData);

        // Display BMI
        displayBMI(bmiResults);
    }
}