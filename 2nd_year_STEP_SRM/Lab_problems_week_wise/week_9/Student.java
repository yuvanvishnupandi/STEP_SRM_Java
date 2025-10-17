import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name='" + name + "']";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {
        Set<Student> studentSet = new HashSet<>();
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(101, "Alicia"); // Duplicate ID

        studentSet.add(s1);
        studentSet.add(s2);
        boolean isAdded = studentSet.add(s3);

        System.out.println("Students in the HashSet:");
        for (Student s : studentSet) {
            System.out.println(s);
        }
        
        System.out.println("\nWas the student with duplicate ID 101 added? " + isAdded);
        System.out.println("Final size of HashSet: " + studentSet.size());
    }
}