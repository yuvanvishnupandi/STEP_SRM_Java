class Course {
    private String courseId;
    private String courseName;
    private int capacity;
    private int enrolled;
    private static int courseCounter = 0;

    public Course(String courseName, int capacity) {
        this.courseId = generateCourseId();
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    private static String generateCourseId() {
        return "CRS" + (++courseCounter);
    }

    public boolean enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId + ", Name: " + courseName +
                ", Enrolled: " + enrolled + "/" + capacity);
    }
}

class StudentUni {
    private String studentId;
    private String name;
    private static int studentCounter = 0;

    public StudentUni(String name) {
        this.studentId = generateStudentId();
        this.name = name;
    }

    private static String generateStudentId() {
        return "UNI" + (++studentCounter);
    }

    public void enroll(Course c) {
        if (c.enrollStudent()) {
            System.out.println(name + " enrolled in " + c);
        } else {
            System.out.println("Course full for " + name);
        }
    }
}

public class Assignment8 {
    public static void main(String[] args) {
        Course c1 = new Course("OOP", 2);
        StudentUni s1 = new StudentUni("Vishnu");
        StudentUni s2 = new StudentUni("Kumar");
        StudentUni s3 = new StudentUni("Ravi");

        s1.enroll(c1);
        s2.enroll(c1);
        s3.enroll(c1);

        c1.displayCourseInfo();
    }
}
