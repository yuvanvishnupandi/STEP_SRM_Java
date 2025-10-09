// File: Employee.java
public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public void displayDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}

// File: Manager.java
public class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus() {
        return salary * 0.20;
    }
}

// File: Developer.java
public class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }
    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }
}

// File: EmployeeTest.java
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Manager("Alice", 50000);
        e1.displayDetails();
        System.out.println("Bonus: " + e1.calculateBonus());

        Employee e2 = new Developer("Bob", 40000);
        e2.displayDetails();
        System.out.println("Bonus: " + e2.calculateBonus());
    }
}
