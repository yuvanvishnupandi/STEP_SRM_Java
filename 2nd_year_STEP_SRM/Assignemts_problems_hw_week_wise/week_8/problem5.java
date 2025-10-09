Topic 5: Abstraction in Real-world Example

// File: BankAccount.java
public abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public abstract void calculateInterest();
}

// File: SavingsAccount.java
public class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Interest: " + interest);
    }
}

// File: CurrentAccount.java
public class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Interest: " + interest);
    }
}

// File: BankTest.java
public class BankTest {
    public static void main(String[] args) {
        BankAccount s = new SavingsAccount(10000);
        s.deposit(2000);
        s.calculateInterest();

        BankAccount c = new CurrentAccount(15000);
        c.deposit(3000);
        c.calculateInterest();
    }
}
