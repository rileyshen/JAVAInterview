package com.exe;

public class CheckAccount extends Account{
    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw (double amount) {
        if (getBalance() >= amount) {
//            方法一：
//           setBalance(getBalance() - amount);
            // 注意super的用法
            super.withdraw(amount);
        } else if (overdraft >= amount - getBalance()) {
            overdraft -= (amount - getBalance());
            // 注意super的用法和withdraw金额
            super.withdraw(getBalance());
        } else {
            System.out.println("exceed your overdraft limit");
        }

    }

    public double getOverdraft() {
        return overdraft;
    }
}
