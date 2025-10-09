LAB PROBLEM 4: Abstract Employee and Payable Interface

// File: Employee.java
public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

// File: Payable.java
public interface Payable {
    void generatePaySlip();
}

// File: Manager.java
public class Manager extends Employee implements Payable {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip for Manager: " + name);
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total Pay: " + (salary + calculateBonus()));
    }
}

// File: EmployeeTest.java
public class EmployeeTest {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 60000);
        m.generatePaySlip();
    }
}
