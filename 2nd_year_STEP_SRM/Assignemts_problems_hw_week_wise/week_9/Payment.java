// Interface for the anonymous class to implement
interface Discount {
    double apply(double amount);
}

public class Payment {

    public void processTransaction(double amount) {
        System.out.println("Processing transaction for amount: " + amount);

        // 1. Local Inner Class (defined inside a method)
        class Validator {
            public boolean isValid() {
                if (amount > 0 && amount < 100000) {
                    System.out.println("Payment amount is valid.");
                    return true;
                } else {
                    System.out.println("Payment amount is invalid.");
                    return false;
                }
            }
        }

        // Create an instance and use the local inner class
        Validator validator = new Validator();
        if (validator.isValid()) {
            // 2. Anonymous Inner Class (implements an interface)
            Discount festivalDiscount = new Discount() {
                @Override
                public double apply(double originalAmount) {
                    // Apply a 10% discount
                    return originalAmount * 0.90;
                }
            };

            double discountedAmount = festivalDiscount.apply(amount);
            System.out.printf("Amount after applying festival discount: %.2f\n", discountedAmount);
            System.out.println("Transaction successful!");
        } else {
            System.out.println("Transaction failed.");
        }
    }

    public static void main(String[] args) {
        Payment p = new Payment();
        
        System.out.println("--- Test Case 1: Valid Amount ---");
        p.processTransaction(5000.00);

        System.out.println("\n--- Test Case 2: Invalid Amount ---");
        p.processTransaction(-150.00);
    }
}