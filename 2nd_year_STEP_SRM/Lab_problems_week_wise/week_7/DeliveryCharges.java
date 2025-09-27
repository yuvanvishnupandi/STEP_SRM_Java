// File: DeliveryCharges.java
// PROBLEM 1: Food Delivery App - Method Overloading

public class DeliveryCharges {

    // Basic delivery: only distance
    public double calculateCharge(double distanceKm) {
        double charge = 20 + distanceKm * 5;
        System.out.println("Basic delivery: base 20 + " + (distanceKm * 5) + " for distance = " + charge);
        return charge;
    }

    // Premium delivery: distance + priority fee
    public double calculateCharge(double distanceKm, boolean isPriority) {
        double base = calculateCharge(distanceKm);
        double priorityFee = isPriority ? 50 : 0;
        double total = base + priorityFee;
        System.out.println("Premium delivery: priority fee " + priorityFee + " => total = " + total);
        return total;
    }

    // Group delivery: distance + discount per extra order
    public double calculateCharge(double distanceKm, int numberOfOrders) {
        double base = calculateCharge(distanceKm);
        double discount = Math.max(0, (numberOfOrders - 1) * 5); // 5 off per extra order
        double total = base - discount;
        System.out.println("Group delivery: orders " + numberOfOrders + " discount " + discount + " => total = " + total);
        return total;
    }

    // Festival special: distance + percent discount, free over amountThreshold
    public double calculateCharge(double distanceKm, double discountPercent, double freeOverAmount) {
        double base = calculateCharge(distanceKm);
        double discounted = base * (1 - discountPercent / 100.0);
        if (base >= freeOverAmount) {
            System.out.println("Festival special: base " + base + " >= free threshold " + freeOverAmount + " => FREE");
            return 0.0;
        } else {
            System.out.println("Festival special: base " + base + " after " + discountPercent + "% discount = " + discounted);
            return discounted;
        }
    }

    public static void main(String[] args) {
        DeliveryCharges d = new DeliveryCharges();
        d.calculateCharge(5); // basic
        d.calculateCharge(10, true); // premium
        d.calculateCharge(8, 3); // group of 3
        d.calculateCharge(12, 20.0, 50); // festival: 20% off, free if base >=50
    }
}
