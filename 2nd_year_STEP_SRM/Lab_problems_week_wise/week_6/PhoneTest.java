// 🧪 LAB PROBLEM 2: Phone and SmartPhone Constructors
// Topic: Constructor Chaining with super()

class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called");
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String os) {
        super(brand, model); // calls parent constructor
        this.operatingSystem = os;
        System.out.println("SmartPhone constructor called");
    }

    public void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }
}

public class PhoneTest {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("Samsung", "S24", "Android");
        sp.showDetails();
    }
}
