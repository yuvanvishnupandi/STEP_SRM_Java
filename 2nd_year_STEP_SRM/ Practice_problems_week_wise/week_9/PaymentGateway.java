// File: PaymentGateway.java
class Payment {
    public void pay() {
        System.out.println("Processing a generic payment.");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment.");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing wallet payment.");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = {new CreditCardPayment(), new WalletPayment(), new CreditCardPayment()};

        for (Payment p : payments) {
            System.out.print(p.getClass().getSimpleName() + ": ");
            p.pay();
        }
    }
}