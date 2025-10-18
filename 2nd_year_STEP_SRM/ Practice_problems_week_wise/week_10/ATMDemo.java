public class ATMDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("123456789", 50000, 1234);

        ATM atm = new ATM(acc);

        Customer cust = new Customer("Priya", atm);

        cust.performWithdrawal(1234, 10000);

        System.out.println("\n--- Next Transaction ---");

        cust.performWithdrawal(9999, 5000);
    }
}