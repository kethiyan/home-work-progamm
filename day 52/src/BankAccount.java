package bank;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Deposit Amount");
        }

        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid Withdraw Amount");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient Balance");
        }

        balance = balance - amount;
    }

    public double checkBalance() {
        return balance;
    }
}