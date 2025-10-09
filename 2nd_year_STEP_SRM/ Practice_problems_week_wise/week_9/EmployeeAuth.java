// File: EmployeeAuth.java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(empCode, employee.empCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empCode);
    }

    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");

        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);
        
        System.out.println("HashSet size: " + employeeSet.size());
        System.out.println(employeeSet);
    }
}