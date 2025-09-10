//PRACTICE PROBLEM 6: Employee Management System
import java.util.*;

class Employee {
    static String companyName;
    static int totalEmployees = 0;
    String empId, name, department;
    double salary;

    Employee(String empId, String name, String dept, double salary) {
        this.empId = empId; this.name = name; this.department = dept; this.salary = salary;
        totalEmployees++;
    }
    public double calculateAnnualSalary() { return salary * 12; }
    public void displayEmployee() {
        System.out.println(empId + " | " + name + " | " + department + " | " + salary);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();

    Department(String name) { deptName = name; }
    public void addEmployee(Employee e) { employees.add(e); }
    public void displayDeptEmployees() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) e.displayEmployee();
    }
    public Employee findHighestPaid() {
        return employees.stream().max(Comparator.comparingDouble(e -> e.salary)).orElse(null);
    }
    public double calculatePayroll() {
        return employees.stream().mapToDouble(e -> e.salary).sum();
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee.companyName = "TechCorp";

        Department d1 = new Department("IT");
        Department d2 = new Department("HR");

        Employee e1 = new Employee("E001", "Alice", "IT", 60000);
        Employee e2 = new Employee("E002", "Bob", "HR", 50000);

        d1.addEmployee(e1);
        d2.addEmployee(e2);

        d1.displayDeptEmployees();
        d2.displayDeptEmployees();

        System.out.println("Highest Paid in HR: " + d2.findHighestPaid().name);
        System.out.println("Company Total Employees: " + Employee.totalEmployees);
        sc.close();
    }
}
