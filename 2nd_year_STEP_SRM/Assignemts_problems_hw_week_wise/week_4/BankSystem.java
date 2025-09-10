import java.util.*;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount() {
        this("Unknown", new Random().nextInt(10000), 0.0);
    }

    BankAccount(String accountHolder) {
        this(accountHolder, new Random().nextInt(10000), 0.0);
    }

    BankAccount(String accountHolder, double balance) {
        this(accountHolder, new Random().nextInt(10000), balance);
    }

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) balance -= amount;
    }

    void displayAccount() {
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolder + " | Balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000);

        a1.deposit(1000);
        a2.deposit(2000);
        a3.withdraw(1000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
