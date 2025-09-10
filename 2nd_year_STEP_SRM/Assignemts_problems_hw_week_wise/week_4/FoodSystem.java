class FoodOrder {
    String customerName, foodItem;
    int quantity;
    double price;

    FoodOrder() {
        this("Unknown", "N/A", 0, 0.0);
    }

    FoodOrder(String foodItem) {
        this("Customer", foodItem, 1, 100.0);
    }

    FoodOrder(String foodItem, int quantity) {
        this("Customer", foodItem, quantity, quantity * 100.0);
    }

    FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    void printBill() {
        System.out.println("Customer: " + customerName + " | Food: " + foodItem + " | Qty: " + quantity + " | Total: " + price);
    }
}

public class FoodSystem {
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("John", "Pasta", 2, 250.0);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
