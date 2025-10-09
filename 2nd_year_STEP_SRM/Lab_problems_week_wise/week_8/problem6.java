LAB PROBLEM 6: Abstract Device and Connectable Interface

// File: Device.java
public abstract class Device {
    protected String brand;
    protected String model;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void powerOn();
}

// File: Connectable.java
public interface Connectable {
    void connect();
}

// File: Smartphone.java
public class Smartphone extends Device implements Connectable {
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void powerOn() {
        System.out.println(brand + " " + model + " is powering on...");
    }

    @Override
    public void connect() {
        System.out.println(brand + " " + model + " connected to Wi-Fi.");
    }
}

// File: DeviceTest.java
public class DeviceTest {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Samsung", "Galaxy S24");
        phone.powerOn();
        phone.connect();
    }
}
