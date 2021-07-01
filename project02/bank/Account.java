package bank;

public class Account {
    private double balance;
    private int id;
    private double annuallInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallInterestRate = annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAnnuallInterestRate() {
        return annuallInterestRate;
    }

    public void setAnnuallInterestRate(double annuallInterestRate) {
        this.annuallInterestRate = annuallInterestRate;
    }

    public void withdraw (double amount) {

        if (amount > balance) {
            System.out.println("Not enough balance for withdrawal");
            return;
        }
        balance -= amount;
        System.out.println("withdraw money successfully: " + amount);
    }

    public void deposit (double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Cash: " + amount);
        }

    }
}
