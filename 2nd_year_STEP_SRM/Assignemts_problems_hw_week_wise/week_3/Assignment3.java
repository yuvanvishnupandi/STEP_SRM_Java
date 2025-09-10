//Assignment 3: Student Grading System
class Student {
    private String studentId;
    private String name;
    private int[] marks;
    private static int counter = 1;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.studentId = generateStudentId();
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    public String calculateGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "D";
    }

    public void displayStudentInfo() {
        System.out.println("ID: " + studentId + " Name: " + name + " Average: " + calculateAverage() + " Grade: " + calculateGrade());
    }

    private static String generateStudentId() {
        return "S" + String.format("%03d", counter++);
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        int[] m1 = {90, 85, 88};
        int[] m2 = {70, 60, 65};
        int[] m3 = {40, 45, 50};

        Student s1 = new Student("Alice", m1);
        Student s2 = new Student("Bob", m2);
        Student s3 = new Student("Charlie", m3);

        s1.displayStudentInfo();
        s2.displayStudentInfo();
        s3.displayStudentInfo();
    }
}
