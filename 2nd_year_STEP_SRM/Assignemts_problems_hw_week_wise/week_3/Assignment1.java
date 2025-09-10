// Assignment 1: Personal Finance Manager
class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    private static int totalAccounts = 0;
    private static String bankName;
    private static int counter = 1;

    public PersonalAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.currentBalance = initialDeposit;
        this.totalIncome = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    private static String generateAccountNumber() {
        return "AC" + String.format("%03d", counter++);
    }
}

public class Assignment1 {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Global Bank");
        PersonalAccount a1 = new PersonalAccount("Alice", 1000);
        PersonalAccount a2 = new PersonalAccount("Bob", 2000);
        PersonalAccount a3 = new PersonalAccount("Charlie", 1500);

        a1.addIncome(500, "Salary");
        a1.addExpense(200, "Groceries");
        a2.addIncome(1000, "Freelance");
        a2.addExpense(300, "Bills");
        a3.addExpense(400, "Shopping");

        a1.displayAccountSummary();
        a2.displayAccountSummary();
        a3.displayAccountSummary();
        System.out.println("Total Accounts: " + PersonalAccount.getTotalAccounts());
    }
}
