import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student[RollNo=" + rollNo + ", Name='" + name + "']";
    }

    /**
     * Two students are equal if they have the same roll number.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    /**
     * The hash code is generated from the roll number to be consistent with equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    public static void main(String[] args) {
        // Create a HashSet to store Student objects
        Set<Student> studentSet = new HashSet<>();

        Student s1 = new Student(10, "Amit");
        Student s2 = new Student(12, "Priya");
        Student s3 = new Student(10, "Amit Sharma"); // Duplicate roll number

        // Add students to the set
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3); // This will be rejected because a student with rollNo 10 already exists

        System.out.println("Students in the HashSet:");
        // The HashSet will only contain unique students based on rollNo
        for (Student student : studentSet) {
            System.out.println(student);
        }

        System.out.println("\nTotal number of unique students: " + studentSet.size());
    }
}