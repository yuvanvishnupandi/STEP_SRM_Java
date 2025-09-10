//PRACTICE PROBLEM 3: Static vs Instance (BankAccount)
public class BankAccount {
    // Static variables
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // Instance variables
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    // Static methods
    public static void setBankName(String name) { bankName = name; }
    public static void setInterestRate(double rate) { interestRate = rate; }
    public static int getTotalAccounts() { return totalAccounts; }
    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts + ", Interest Rate: " + interestRate + "%");
    }

    // Instance methods
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { if (balance >= amount) balance -= amount; }
    public void calculateInterest() { balance += (balance * interestRate / 100); }
    public void displayAccountInfo() {
        System.out.println(accountHolder + " (" + accountNumber + ") Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount.setBankName("HDFC Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount a1 = new BankAccount("101", "Alice", 1000);
        BankAccount a2 = new BankAccount("102", "Bob", 2000);

        a1.deposit(500);
        a2.withdraw(300);
        a1.calculateInterest();
        a2.calculateInterest();

        a1.displayAccountInfo();
        a2.displayAccountInfo();

        BankAccount.displayBankInfo();
    }
}
