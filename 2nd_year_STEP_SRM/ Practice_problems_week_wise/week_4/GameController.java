public class GameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public GameController() {
        this("GenericPad", "USB", true, 100, 1.0);
    }

    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = Math.max(0, Math.min(100, batteryLevel));
        this.sensitivity = Math.max(0.1, Math.min(3.0, sensitivity));
    }

    public GameController(String brand, String connectionType) {
        this(brand, connectionType, true, 100, 1.0);
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand + " | Connection: " + connectionType + " | Vibration: " + hasVibration + " | Battery: " + batteryLevel + "% | Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) System.out.println("*BUZZ* Vibration test successful!");
        else System.out.println("Vibration disabled on this controller.");
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");
        GameController c1 = new GameController();
        GameController c2 = new GameController("Xbox", "Wireless", true, 85, 2.5);
        GameController c3 = new GameController("PS", "USB");
        c1.displayConfiguration();
        c2.displayConfiguration();
        c3.displayConfiguration();
        c1.calibrateController();
        c2.testVibration();
        c3.calibrateController();
    }
}
