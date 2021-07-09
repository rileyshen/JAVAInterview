package com.exe;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return annualInterestRate/12;
    }
    public void withdraw (double amount) {
        if (balance < amount) {
            System.out.println("fails to withdraw, your balance is: " + balance);
            return;
        }
        balance -= amount;

        return;
    }
    public void deposit (double amount) {
        balance =+ amount;
        return;
    }

//    public static void main(String[] args) {
//        Account account = new Account(1122, 20000, 0.045);
//        account.withdraw(30000);
//        account.withdraw(2500);
//        account.deposit(30000);
//        System.out.println("your balance is: " + account.getBalance());
//        System.out.println(account.getMonthlyInterest());
//    }
}
