class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int counter = 0;

    public Employee(String empName, String department, double baseSalary, String empType) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = empType;
        totalEmployees++;
    }

    private static String generateEmpId() {
        counter++;
        return "E" + String.format("%03d", counter);
    }

    public double calculateSalary(double bonus) {
        return baseSalary + bonus;
    }

    public double calculateSalary(int hours, double rate) {
        return hours * rate;
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public double calculateTax(double salary, double rate) {
        return salary * rate;
    }

    public void generatePaySlip(double salary, double tax) {
        System.out.println(empId + " | " + empName + " | " + empType + " | Salary: " + salary + " | Tax: " + tax);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public void displayEmployeeInfo() {
        System.out.println(empId + " | " + empName + " | " + department + " | " + empType);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000, "Full-time");
        Employee e2 = new Employee("Bob", "HR", 0, "Part-time");
        Employee e3 = new Employee("Charlie", "Finance", 40000, "Contract");

        double s1 = e1.calculateSalary(5000);
        double t1 = e1.calculateTax(s1, 0.1);
        e1.generatePaySlip(s1, t1);

        double s2 = e2.calculateSalary(100, 200);
        double t2 = e2.calculateTax(s2, 0.05);
        e2.generatePaySlip(s2, t2);

        double s3 = e3.calculateSalary();
        double t3 = e3.calculateTax(s3, 0.08);
        e3.generatePaySlip(s3, t3);

        System.out.println("Total Employees: " + Employee.getTotalEmployees());
    }
}
