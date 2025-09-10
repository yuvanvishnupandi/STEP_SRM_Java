// Assignment 7: Hospital Management System
class Patient {
    private String patientId;
    private String name;
    private int age;
    private String disease;
    private static int patientCounter = 0;

    public Patient(String name, int age, String disease) {
        this.patientId = generatePatientId();
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    private static String generatePatientId() {
        return "PAT" + (++patientCounter);
    }

    public void displayPatientInfo() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Disease: " + disease);
    }
}

class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private static int doctorCounter = 0;

    public Doctor(String name, String specialization) {
        this.doctorId = generateDoctorId();
        this.name = name;
        this.specialization = specialization;
    }

    private static String generateDoctorId() {
        return "DOC" + (++doctorCounter);
    }

    public void treatPatient(Patient p) {
        System.out.println("Doctor " + name + " is treating patient: " + p);
    }
}

public class Assignment7 {
    public static void main(String[] args) {
        Patient p1 = new Patient("Arun", 30, "Fever");
        Doctor d1 = new Doctor("Dr. Ramesh", "General Medicine");

        p1.displayPatientInfo();
        d1.treatPatient(p1);
    }
}
