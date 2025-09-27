// 🧪 PROBLEM 6: Smart Campus IoT System
// Concept: Safe Downcasting with instanceof

class SmartDevice {
    String name;
    SmartDevice(String name){ this.name = name; }
    void status(){ System.out.println(name + " is active"); }
}

class SmartClassroom extends SmartDevice {
    SmartClassroom(String name){ super(name); }
    void controlLights(){ System.out.println(name + ": controlling lights"); }
}

class SmartLab extends SmartDevice {
    SmartLab(String name){ super(name); }
    void manageEquipment(){ System.out.println(name + ": managing lab equipment"); }
}

class SmartLibrary extends SmartDevice {
    SmartLibrary(String name){ super(name); }
    void trackBooks(){ System.out.println(name + ": tracking books"); }
}

public class Problem6 {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("Room101"),
            new SmartLab("ChemLab"),
            new SmartLibrary("CentralLibrary")
        };

        for(SmartDevice d : devices){
            d.status();
            if(d instanceof SmartClassroom) ((SmartClassroom)d).controlLights();
            if(d instanceof SmartLab) ((SmartLab)d).manageEquipment();
            if(d instanceof SmartLibrary) ((SmartLibrary)d).trackBooks();
        }
    }
}
