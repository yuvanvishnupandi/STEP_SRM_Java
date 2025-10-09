Topic 3: Abstract Class + Interface Together

// File: Vehicle.java
public abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

// File: Fuel.java
public interface Fuel {
    void refuel();
}

// File: Car.java
public class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueled with petrol.");
    }
}

// File: VehicleTest.java
public class VehicleTest {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
        c.refuel();
    }
}
