// File: HospitalManagement.java
class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;
        
        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println("Hospital: " + Hospital.this.name + ", Department: " + this.deptName);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital cityHospital = new Hospital("City General Hospital");
        Hospital.Department cardiology = cityHospital.createDepartment("Cardiology");
        Hospital.Department neurology = cityHospital.createDepartment("Neurology");
        
        cardiology.displayInfo();
        neurology.displayInfo();
    }
}