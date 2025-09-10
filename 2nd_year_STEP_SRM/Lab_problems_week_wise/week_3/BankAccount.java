// Bank Account Management System
class BankAccount{
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int counter = 0;

    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    private static String generateAccountNumber() {
        counter++;
        return "ACC" + String.format("%03d", counter);
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Invalid deposit amount");
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) balance -= amount;
        else System.out.println("Insufficient balance or invalid amount");
    }

    public void checkBalance() {
        System.out.println(accountHolderName + " Balance: " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountInfo() {
        System.out.println(accountNumber + " | " + accountHolderName + " | Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount("Alice", 1000);
        accounts[1] = new BankAccount("Bob", 2000);
        accounts[2] = new BankAccount("Charlie", 3000);

        accounts[0].deposit(500);
        accounts[1].withdraw(1000);
        accounts[2].checkBalance();

        for (BankAccount acc : accounts) acc.displayAccountInfo();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
