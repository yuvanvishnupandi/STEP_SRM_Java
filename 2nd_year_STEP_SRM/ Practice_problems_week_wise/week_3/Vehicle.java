// PRACTICE PROBLEM 4: Vehicle Reusability
class Vehicle {
    protected String make, model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() { System.out.println(make + " " + model + " started."); }
    public void stopVehicle() { System.out.println(make + " " + model + " stopped."); }
    public void refuel(double amount) { fuelLevel += amount; }
    public void displayVehicleInfo() {
        System.out.println(make + " " + model + " (" + year + "), Fuel: " + fuelLevel);
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota", "Camry", 2020, 50);
        Vehicle v2 = new Vehicle("Ford", "Truck", 2019, 70);
        Vehicle v3 = new Vehicle("Yamaha", "Bike", 2022, 20);

        Vehicle[] vehicles = {v1, v2, v3};
        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
            v.stopVehicle();
        }
        // Reusability: Same Vehicle class reused for Car/Truck/Bike
        // Extensibility: New vehicle types can be added easily
    }
}
