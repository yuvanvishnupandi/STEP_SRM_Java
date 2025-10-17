public class Car {
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[Brand=" + brand + ", Model=" + model + ", Price=$" + String.format("%,.2f", price) + "]";
    }

    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", 25000.00);

        // 1. Print the object details by invoking toString() implicitly
        System.out.println("Car Details: " + myCar);

        // 2. Print the runtime class name of the object
        System.out.println("Class Name: " + myCar.getClass().getName());
    }
}