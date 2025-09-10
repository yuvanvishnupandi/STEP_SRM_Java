import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

// Immutable Product
final class Product {
    private final String productId, name, category, manufacturer;
    private final double basePrice;
    private final Map<String, String> specifications;

    private Product(String id, String name, String category, String maker, double price, Map<String, String> specs) {
        this.productId = id;
        this.name = name;
        this.category = category;
        this.manufacturer = maker;
        this.basePrice = price;
        this.specifications = new HashMap<>(specs);
    }

    public static Product createElectronics(String id, String name, double price) {
        return new Product(id, name, "Electronics", "Generic", price, Map.of("Warranty", "1yr"));
    }

    public final double calculateTax(String region) { return basePrice * 0.18; }
    public String toString() { return name + "(" + category + ") Rs." + basePrice; }
}

// Customer
class Customer {
    private final String customerId, email, accountCreationDate;
    private String name, phone;

    Customer(String id, String email) {
        this.customerId = id;
        this.email = email;
        this.accountCreationDate = LocalDate.now().toString();
    }

    public String getPublicProfile() { return "Customer:" + name + " (" + email + ")"; }
    String getCreditRating() { return "Good"; }
}

// ShoppingCart
class ShoppingCart {
    private final String cartId, customerId;
    private List<Product> items = new ArrayList<>();
    private double total;

    ShoppingCart(String cid) {
        this.cartId = "CART-" + UUID.randomUUID();
        this.customerId = cid;
    }

    public boolean addItem(Object obj, int qty) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            for (int i = 0; i < qty; i++) items.add(p);
            total += qty * (p.calculateTax("IN") + 100); // price+tax
            return true;
        }
        return false;
    }

    String getCartSummary() { return items.size() + " items, Total=" + total; }
}

// Order
class Order {
    private final String orderId = UUID.randomUUID().toString();
    private final LocalDateTime time = LocalDateTime.now();
    public String toString() { return "Order " + orderId + " at " + time; }
}

// Payment Processor
class PaymentProcessor {
    public boolean process(Order o, Customer c) { return true; }
}

// E-Commerce System
final class ECommerceSystem {
    private static final Map<String, Object> catalog = new HashMap<>();
    public static boolean processOrder(Object order, Object customer) {
        return (order instanceof Order && customer instanceof Customer);
    }
}

// Demo
public class ECommerceDemo {
    public static void main(String[] args) {
        Product phone = Product.createElectronics("E1", "Smartphone", 20000);
        Customer cust = new Customer("C1", "test@mail.com");
        ShoppingCart cart = new ShoppingCart("C1");

        cart.addItem(phone, 2);
        Order order = new Order();

        System.out.println("Cart summary: " + cart.getCartSummary());
        System.out.println("Order processed: " + ECommerceSystem.processOrder(order, cust));
    }
}
