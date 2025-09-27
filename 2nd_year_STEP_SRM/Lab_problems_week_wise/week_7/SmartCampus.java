// File: SmartCampus.java
// PROBLEM 6: Smart Campus IoT System - Safe Downcasting with instanceof

class SmartDevice {
    protected String id;
    public SmartDevice(String id) { this.id = id; }
    public void status() { System.out.println("Device " + id + " status OK"); }
}

class SmartClassroom extends SmartDevice {
    public SmartClassroom(String id) { super(id); }
    public void controlLights(String mode) { System.out.println("Classroom " + id + " lights set to " + mode); }
    public void controlAC(int temp) { System.out.println("Classroom " + id + " AC set to " + temp + "°C"); }
    public void controlProjector(boolean on) { System.out.println("Classroom " + id + " projector " + (on ? "ON" : "OFF")); }
}

class SmartLab extends SmartDevice {
    public SmartLab(String id) { super(id); }
    public void checkEquipment() { System.out.println("Lab " + id + " equipment checked"); }
    public void safetyLock(boolean lock) { System.out.println("Lab " + id + " safety lock " + (lock ? "ENGAGED" : "RELEASED")); }
}

class SmartLibrary extends SmartDevice {
    public SmartLibrary(String id) { super(id); }
    public void trackOccupancy() { System.out.println("Library " + id + " occupancy updated"); }
    public void findBook(String title) { System.out.println("Searching for '" + title + "' in " + id); }
}

public class SmartCampus {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("CR-101"),
            new SmartLab("LAB-5"),
            new SmartLibrary("LIB-A")
        };

        for (SmartDevice d : devices) {
            d.status();

            if (d instanceof SmartClassroom) {
                SmartClassroom c = (SmartClassroom) d;
                c.controlLights("DIM");
                c.controlAC(22);
                c.controlProjector(true);
            } else if (d instanceof SmartLab) {
                SmartLab l = (SmartLab) d;
                l.checkEquipment();
                l.safetyLock(true);
            } else if (d instanceof SmartLibrary) {
                SmartLibrary lib = (SmartLibrary) d;
                lib.trackOccupancy();
                lib.findBook("Data Structures");
            }
        }
    }
}
