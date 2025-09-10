class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int rentalDays = 0;
    private static int counter = 0;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    private static String generateVehicleId() {
        counter++;
        return "V" + String.format("%03d", counter);
    }

    public void rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double rent = calculateRent(days);
            totalRevenue += rent;
            rentalDays += days;
            System.out.println(vehicleId + " rented for " + days + " days. Rent: " + rent);
        } else System.out.println("Vehicle not available");
    }

    public void returnVehicle() {
        isAvailable = true;
    }

    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + " | Total Vehicles: " + totalVehicles + " | Revenue: " + totalRevenue);
    }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " | " + brand + " | " + model + " | Rent/Day: " + rentPerDay + " | Available: " + isAvailable);
    }

    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomCars");
        Vehicle v1 = new Vehicle("Toyota", "Camry", 1000);
        Vehicle v2 = new Vehicle("Honda", "Civic", 800);

        v1.rentVehicle(3);
        v2.rentVehicle(2);
        v1.returnVehicle();

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        Vehicle.displayCompanyStats();
        System.out.println("Average Rent per Day: " + Vehicle.getAverageRentPerDay());
    }
}
