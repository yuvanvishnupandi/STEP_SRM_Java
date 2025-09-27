public class Vehicle {
    // protected fields
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // private fields
    private String registrationNumber;
    private boolean isRunning;

    // default constructor
    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = "REG" + (int)(Math.random() * 10000);
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG" + (int)(Math.random() * 10000);
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    // methods
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
               ", Engine: " + engineType + ", Reg#: " + registrationNumber +
               ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Engine: " + engineType);
    }

    // getters and setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}