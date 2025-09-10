import java.time.LocalDate;
import java.util.*;

// Immutable Medical Record
final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String dna, String[] allergies, String[] history, LocalDate birthDate, String bloodType) {
        this.recordId = Objects.requireNonNull(recordId);
        this.patientDNA = Objects.requireNonNull(dna);
        this.allergies = (allergies == null) ? new String[0] : allergies.clone();
        this.medicalHistory = (history == null) ? new String[0] : history.clone();
        this.birthDate = Objects.requireNonNull(birthDate);
        this.bloodType = Objects.requireNonNull(bloodType);
    }

    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String a : allergies) if (a.equalsIgnoreCase(substance)) return true;
        return false;
    }

    public String toString() {
        return "MedicalRecord[" + recordId + ", Blood=" + bloodType + "]";
    }
}

// Patient class
class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName, emergencyContact, insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    // Emergency admission
    Patient(String name) {
        this.patientId = "TEMP-" + System.nanoTime();
        this.medicalRecord = new MedicalRecord("MR-" + UUID.randomUUID(), "DNA??",
                new String[0], new String[0], LocalDate.now().minusYears(25), "O+");
        this.currentName = name;
    }

    // Standard admission
    Patient(String id, MedicalRecord rec, String name, int room, String doctor) {
        this.patientId = id;
        this.medicalRecord = rec;
        this.currentName = name;
        this.roomNumber = room;
        this.attendingPhysician = doctor;
    }

    // Transfer admission
    Patient(String id, MedicalRecord rec) {
        this(id, rec, "Transferred", -1, "");
    }

    String getBasicInfo() { return patientId + " | " + currentName; }
    public String getPublicInfo() { return "Patient: " + currentName + " Room: " + roomNumber; }

    public String toString() { return "Patient[" + currentName + " -> " + medicalRecord + "]"; }
}

// Staff classes
final class Doctor {
    private final String licenseNumber;
    Doctor(String lic) { this.licenseNumber = lic; }
}

final class Nurse {
    private final String nurseId;
    Nurse(String id) { this.nurseId = id; }
}

final class Administrator {
    private final String adminId;
    Administrator(String id) { this.adminId = id; }
}

// Hospital System
final class HospitalSystem {
    private final Map<String, Patient> registry = new HashMap<>();
    public static final String PRIVACY_POLICY = "HIPAA-STRICT";

    public boolean admitPatient(Patient p, Object staff) {
        if (validateStaffAccess(staff)) {
            registry.put(p.getPublicInfo(), p);
            return true;
        }
        return false;
    }

    private boolean validateStaffAccess(Object staff) {
        return (staff instanceof Doctor) || (staff instanceof Nurse);
    }

    public String toString() { return "Hospital Registry=" + registry.keySet(); }
}

// Demo
public class HospitalDemo {
    public static void main(String[] args) {
        MedicalRecord rec = new MedicalRecord("R1", "DNA123",
                new String[]{"Peanuts"}, new String[]{"Asthma"},
                LocalDate.of(2000, 1, 1), "B+");

        Patient pat = new Patient("P1", rec, "John", 101, "Dr.Smith");
        Doctor doc = new Doctor("DOC-1");
        HospitalSystem hs = new HospitalSystem();

        System.out.println("Admit result: " + hs.admitPatient(pat, doc));
        System.out.println(pat.getPublicInfo());
    }
}
