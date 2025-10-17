public class Employee {
    // Fields for the Employee class
    private int id;
    private String name;
    private double salary;

    /**
     * Constructor to initialize the Employee object.
     * @param id The employee's ID.
     * @param name The employee's name.
     * @param salary The employee's salary.
     */
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Overrides the default toString() method to provide a meaningful
     * string representation of the Employee object. [cite: 11]
     * @return A formatted string with employee details.
     */
    @Override
    public String toString() {
        return "Employee[ID=" + id + ", Name='" + name + "', Salary=" + String.format("%.2f", salary) + "]";
    }

    public static void main(String[] args) {
        // Create multiple Employee objects [cite: 9]
        Employee emp1 = new Employee(1, "Suresh Kumar", 75000.50);
        Employee emp2 = new Employee(2, "Priya Singh", 82000.75);

        // 1. Print object details (implicitly calls toString())
        System.out.println("--- Employee Details ---");
        System.out.println(emp1);
        System.out.println(emp2);
        
        System.out.println(); // for spacing

        // 2. Print the class name using getClass().getName() [cite: 12]
        System.out.println("--- Runtime Class Information ---");
        System.out.println("The class for emp1 is: " + emp1.getClass().getName());
        System.out.println("The class for emp2 is: " + emp2.getClass().getName());
    }
}