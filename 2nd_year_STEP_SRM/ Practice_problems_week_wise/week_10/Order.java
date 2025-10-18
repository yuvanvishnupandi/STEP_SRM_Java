import java.util.*;

public class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + this.orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order " + this.orderId + " contains:");
        for (Product p : products) {
            p.showDetails();
        }
    }
}