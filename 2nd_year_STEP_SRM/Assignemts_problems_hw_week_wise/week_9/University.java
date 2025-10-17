public class University {
    private String universityName = "Tech University";

    // 1. Member Inner Class
    public class Department {
        // Can access outer class's private members directly
        public void displayDepartment() {
            System.out.println("Department is part of: " + universityName);
        }
    }

    // 2. Static Nested Class
    public static class ExamCell {
        // Cannot access non-static members of the outer class
        public static void conductExams() {
            System.out.println("ExamCell is conducting university-wide exams.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of the outer class
        University uni = new University();

        // --- Accessing the Member Inner Class ---
        // An instance is created using the outer class instance [cite: 49]
        University.Department cseDept = uni.new Department();
        System.out.println("Accessing Member Inner Class:");
        cseDept.displayDepartment();
        
        System.out.println(); // for spacing

        // --- Accessing the Static Nested Class ---
        // Accessed directly through the outer class name
        System.out.println("Accessing Static Nested Class:");
        University.ExamCell.conductExams();
    }
}