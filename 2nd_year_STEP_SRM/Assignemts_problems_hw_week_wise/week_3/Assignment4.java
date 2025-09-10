// Assignment 4: Student Grade Management System
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int[] marks;
    private double average;
    private char grade;
    private static int totalStudents = 0;

    public Student(String name, int[] marks) {
        this.studentId = generateStudentId();
        this.name = name;
        this.marks = marks;
        this.average = calculateAverage();
        this.grade = assignGrade();
        totalStudents++;
    }

    private static String generateStudentId() {
        return "STU" + String.format("%03d", totalStudents + 1);
    }

    private double calculateAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    private char assignGrade() {
        if (average >= 90) return 'A';
        else if (average >= 75) return 'B';
        else if (average >= 60) return 'C';
        else if (average >= 50) return 'D';
        else return 'F';
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Average: " + average + ", Grade: " + grade);
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}

public class Assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            int[] marks = new int[3];
            System.out.println("Enter 3 marks:");
            for (int j = 0; j < 3; j++) marks[j] = sc.nextInt();
            sc.nextLine();
            students[i] = new Student(name, marks);
        }

        System.out.println("\nStudent Details:");
        for (Student s : students) s.displayStudentInfo();
        System.out.println("Total Students: " + Student.getTotalStudents());
        sc.close();
    }
}
