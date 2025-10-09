LAB PROBLEM 3: Abstract Vehicle and Maintainable Interface

// File: Vehicle.java
public abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

// File: Maintainable.java
public interface Maintainable {
    void serviceInfo();
}

// File: Car.java
public class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println(model + " engine started with " + fuelType);
    }

    @Override
    public void serviceInfo() {
        System.out.println(model + " requires servicing every 6 months.");
    }
}

// File: VehicleTest.java
public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car(120, "Petrol", "Honda City");
        car.startEngine();
        car.serviceInfo();
    }
}
