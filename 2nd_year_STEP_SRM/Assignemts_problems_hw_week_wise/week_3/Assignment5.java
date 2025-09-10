// Assignment 5: Online Shopping Cart System
class Product {
    private String productId;
    private String name;
    private double price;
    private static int productCounter = 0;

    public Product(String name, double price) {
        this.productId = generateProductId();
        this.name = name;
        this.price = price;
    }

    private static String generateProductId() {
        return "P" + (++productCounter);
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

class Cart {
    private Product[] products;
    private int count;
    private static double totalRevenue = 0;

    public Cart(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product p) {
        if (count < products.length) {
            products[count++] = p;
            totalRevenue += p.getPrice();
        } else {
            System.out.println("Cart is full!");
        }
    }

    public void displayCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < count; i++) {
            products[i].displayProductInfo();
        }
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }
}

public class Assignment5 {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 20000);

        Cart cart = new Cart(5);
        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.displayCart();
        System.out.println("Total Revenue: " + Cart.getTotalRevenue());
    }
}
