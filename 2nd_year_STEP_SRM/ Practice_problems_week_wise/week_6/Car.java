public class Car extends Vehicle {
    // car-specific fields
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    // default constructor
    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    // parameterized constructor
    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    // override start()
    @Override
    public void start() {
        super.start();
        System.out.println("Car specific startup sequence");
    }

    // override displaySpecs()
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType + ", Transmission: " + transmissionType);
    }

    // car-specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        // 1. default constructor
        Car car1 = new Car();
        car1.start();
        car1.displaySpecs();
        car1.openTrunk();
        car1.playRadio();
        car1.stop();

        System.out.println();

        // 2. parameterized constructor
        Car car2 = new Car("Toyota", "Corolla", 2022, "Hybrid", 4, "Petrol", "Automatic");
        car2.start();
        System.out.println(car2.getVehicleInfo());
        car2.displaySpecs();
        car2.stop();
    }
}