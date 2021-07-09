package com.exe;

/**
 * Description: Test class
 * create: id: 1122, balance 20000, annalinterest 4.5%, overdraft 5000 CheckAccount
 * withdraw 5000
 * withdraw 18000
 * withdraw 3000
 *
 */
public class CheckTest {
    public static void main(String[] args) {

        CheckAccount checkAccount = new CheckAccount(1122, 20000, 0.045, 5000);
        checkAccount.withdraw(5000);
        System.out.println("your balance is: " + checkAccount.getBalance() + "your overdraft is: " + checkAccount.getOverdraft());
        checkAccount.withdraw(18000);
        System.out.println("your balance is: " + checkAccount.getBalance() + "your overdraft is: " + checkAccount.getOverdraft());
        checkAccount.withdraw(3000);
        System.out.println("your balance is: " + checkAccount.getBalance() + "your overdraft is: " + checkAccount.getOverdraft());
    }
}
