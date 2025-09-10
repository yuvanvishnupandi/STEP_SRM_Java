import java.util.*;

public class ZaraBonusCalculator {

    public static double[][] generateEmployeeData(int n) {
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = 10000 + (int)(Math.random() * 90000);
            data[i][1] = (int)(Math.random() * 11);
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        int n = data.length;
        double[][] updatedData = new double[n][3];
        for (int i = 0; i < n; i++) {
            double salary = data[i][0];
            int service = (int)data[i][1];
            double bonus = service > 5 ? salary * 0.05 : salary * 0.02;
            updatedData[i][0] = salary;
            updatedData[i][1] = bonus;
            updatedData[i][2] = salary + bonus;
        }
        return updatedData;
    }

    public static void displaySummary(double[][] updatedData) {
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Emp No", "Old Salary", "Years of Service", "Bonus", "New Salary");
        for (int i = 0; i < updatedData.length; i++) {
            double oldSalary = updatedData[i][0];
            double bonus = updatedData[i][1];
            double newSalary = updatedData[i][2];
            double years = updatedData[i][0] == 0 ? 0 : (oldSalary < 20000 ? 2 : 6); // approximation
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-10d %-15.2f %-15.0f %-15.2f %-15.2f\n", (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displaySummary(updatedData);
    }
}
