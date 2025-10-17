import java.util.Objects;

public class Product {
    private int productId;
    private String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    /**
     * Overrides the equals method to compare Product objects based on their productId.
     * @param o The object to compare with.
     * @return true if the productIds are the same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // 1. Check if the object is being compared with itself
        if (this == o) return true;
        // 2. Check if the object is null or of a different class
        if (o == null || getClass() != o.getClass()) return false;
        // 3. Cast the object to Product type and compare the productId
        Product product = (Product) o;
        return productId == product.productId;
    }

    public static void main(String[] args) {
        // Create three Product objects
        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop"); // Same content, different object
        Product p3 = p1; // Same object reference as p1

        System.out.println("--- Comparing p1 and p2 (different objects, same content) ---");
        System.out.println("Using == operator: " + (p1 == p2)); // false: they are different objects in memory
        System.out.println("Using .equals() method: " + p1.equals(p2)); // true: their productIds are the same
        
        System.out.println("\n--- Comparing p1 and p3 (same object reference) ---");
        System.out.println("Using == operator: " + (p1 == p3)); // true: they point to the same object
        System.out.println("Using .equals() method: " + p1.equals(p3)); // true: their content is the same
    }
}