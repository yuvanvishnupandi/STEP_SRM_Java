// Assignment 2: Online Shopping Cart System
class Product {
    private String productId;
    private String name;
    private double price;
    private static int counter = 1;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.productId = generateProductId();
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    private static String generateProductId() {
        return "P" + String.format("%03d", counter++);
    }
}

class Cart {
    private Product[] products;
    private int count;

    public Cart(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
        }
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i] = products[count - 1];
                products[count - 1] = null;
                count--;
                break;
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void displayCart() {
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getProductId() + " - " + products[i].getName() + " : " + products[i].getPrice());
        }
        System.out.println("Total: " + calculateTotal());
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 20000);
        Product p3 = new Product("Headphones", 2000);

        Cart cart = new Cart(5);
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        cart.displayCart();

        cart.removeProduct(p2.getProductId());
        System.out.println("After removing:");
        cart.displayCart();
    }
}
