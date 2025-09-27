// 🧪 PROBLEM 1: Food Delivery App
// Concept: Method Overloading

class Delivery {
    void calculateCharge(double distance) {
        System.out.println("Basic delivery charge for " + distance + " km: $" + (distance * 5));
    }

    void calculateCharge(double distance, double priorityFee) {
        System.out.println("Premium delivery charge: " + distance*5 + " + priority fee " + priorityFee + " = $" + (distance*5 + priorityFee));
    }

    void calculateCharge(double distance, int orders) {
        double discount = orders * 2;
        System.out.println("Group delivery charge for " + orders + " orders: $" + (distance*5 - discount));
    }

    void calculateCharge(double distance, double discountPercent, double totalAmount) {
        double charge = distance*5;
        charge = charge - charge*discountPercent/100;
        if(totalAmount > 100) charge = 0;
        System.out.println("Festival delivery charge: $" + charge);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Delivery d = new Delivery();
        d.calculateCharge(10);
        d.calculateCharge(10, 20);
        d.calculateCharge(10, 5);
        d.calculateCharge(10, 20, 150);
    }
}
